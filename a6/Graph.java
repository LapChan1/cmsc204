package a6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Graph implements GraphInterface<Town,Road> {
	ArrayList<Town> townList;
	ArrayList<Road> roadList;
	int[][] adjMatrix;
	HashMap<int[],ArrayList<ArrayList<Town>>> shortestPaths;
	ArrayList<int[]> pathList;
	
	public Graph() {
		townList=new ArrayList<Town>(20);
		roadList=new ArrayList<Road>(20);
	}
	
	@Override
	public Road getEdge(Town t1, Town t2) {
		if(!this.containsVertex(t2) || !this.containsVertex(t1))
			return null;
		for(int i=0;i<roadList.size();i++) {
			Road temp= roadList.get(i);
			//temp2 = same road but with destination and source town reversed
			Road temp2= new Road(roadList.get(i).getDestination(),roadList.get(i).getSource()
					,roadList.get(i).getWeight(),roadList.get(i).getName());;
			if(temp.getDestination().equals(t1) && temp.getSource().equals(t2)) {
				return temp2;}
			else if(temp.getDestination().equals(t2) && temp.getSource().equals(t1)) {
				return temp;  
			}
		}
		return null;
	}
	
	public Town getVertex(String n) {
		for(int i=0;i<townList.size();i++)
			if(townList.get(i).getName().equals(n))
				return townList.get(i);
		return null;	
	}

	@Override
	public Road addEdge(Town t1, Town t2, int weight, String name) throws NullPointerException,IllegalArgumentException{
		if(!this.containsVertex(t2) || !this.containsVertex(t1))
			throw new IllegalArgumentException();
		Road r = new Road(t1,t2,weight,name);
		roadList.add(r);
		return r;
	}

	@Override
	public boolean addVertex(Town v) {
		if(townList.contains(v))
			return false;
		else
			return townList.add(v);
	}

	@Override
	public boolean containsEdge(Town t1, Town t2) {
		for(int i=0;i<roadList.size();i++) {
			Road temp= roadList.get(i);
			if(temp.getDestination().equals(t1) && temp.getSource().equals(t2))
				return true;
			else if(temp.getDestination().equals(t2) && temp.getSource().equals(t1))
				return true;
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		for(int i=0;i<townList.size();i++) {
			if(townList.get(i).equals(v))
				return true;
		}
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		Set<Road> s = new HashSet<Road>(roadList);
		return s;
	}

	@Override
	public Set<Road> edgesOf(Town t) {
		Set<Road> s = new HashSet<Road>();
		for(Road r : edgeSet()) {
			if(r.contains(t))
				s.add(r);
		}
		return s;
	}

	@Override
	public Road removeEdge(Town t1, Town t2, int weight, String name) {
		Road r = new Road(t1,t2,weight,name);
		if(roadList.contains(r))
			return roadList.remove(roadList.indexOf(r));
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		if(townList.contains(v))
			return townList.remove(v);
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		Set<Town> tSet=new HashSet<Town>(townList);
		return tSet;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		dijkstraShortestPath(sourceVertex);
		ArrayList<Town> pathList=shortestPaths.get(sourceVertex.paths).get(townList.indexOf(destinationVertex));
		ArrayList<String> townPath=new ArrayList<String>();
		for(int i=0;i<pathList.size();i++) {
			String s=sourceVertex.toString()+" via ";
			
			
		}
		return null;
	}
	
	
	
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		adjMatrix=new int[townList.size()][townList.size()];
		int srcIndex=townList.indexOf(sourceVertex);
		
		for(int m=0;m<townList.size();m++) {
			for(int n=0;n<townList.size();n++) {
			adjMatrix[n][m]= -1;
				if(n==m) {
					adjMatrix[n][m]=0;
				}
			}
		}
		for(Road r:roadList) {
			adjMatrix[townList.indexOf(r.getDestination())][townList.indexOf(r.getSource())]=r.getWeight();
			adjMatrix[townList.indexOf(r.getSource())][townList.indexOf(r.getDestination())]=r.getWeight();
		}


		int[] distance=new int[townList.size()];//best distance from src to other town
		Boolean[] visited= new Boolean[townList.size()];
		for(int i=0;i<townList.size();i++) {
			distance[i]=adjMatrix[srcIndex][i];
		}
		
		for (int j = 0; j < townList.size(); j++)   
		{  
			if(distance[j]==-1)
				distance[j] = Integer.MAX_VALUE;  
			visited[j] = false;  
		}  
		
		ArrayList<ArrayList<Town>> pathList=new ArrayList<ArrayList<Town>>();
		shortestPaths=new HashMap<int[],ArrayList<ArrayList<Town>>>();
		shortestPaths.put(distance, pathList); 
				  
		// compute the shortest path for all the given vertices  
		for (int i = 0; i < townList.size() - 1; i++)   
		{   
			
			int nxtVertex = closestTown(distance, visited);  
			visited[nxtVertex] = true;  

			for (int vertex = 0; vertex < townList.size(); vertex++) { 
					//update distance when:
					// not visited, there is a road, new distance is smaller
				if (!visited[vertex] && adjMatrix[nxtVertex][vertex] != -1 && distance[nxtVertex] 
						!= Integer.MAX_VALUE && distance[nxtVertex] + adjMatrix[nxtVertex][vertex] < distance[vertex])  
					{  
					distance[vertex] = distance[nxtVertex] + adjMatrix[nxtVertex][vertex];  
					}
				}
		}  
		townList.get(srcIndex).paths=distance;
		
		for(int i=0;i<townList.size();i++) {
			System.out.print(distance[i]+" ");//srcVertex path array
		}
		System.out.println();

		printMatrix(); 
		
	}
	/**
	 * check which non-visited vertex is closest
	 * @param distance
	 * @param visited
	 * @return
	 */
	public int closestTown(int distance[], Boolean visited[])  
	{   
		int closest = Integer.MAX_VALUE, closest_index = -1;  
		for (int vertex = 0; vertex < townList.size(); vertex++)  
		{  
			if (visited[vertex]==false && distance[vertex] <= closest)   
			{  
				closest = distance[vertex];  
				closest_index = vertex;  
			}  
		}  
		return closest_index;  
	  
	}  
	
	
	/**
	 * print adjMatrix
	 */
	public void printMatrix() {
		for(int m=0;m<townList.size();m++) {//print matrix
			for(int n=0;n<townList.size();n++) {
				System.out.printf("%4d", adjMatrix[m][n]);
			}
			System.out.println();
		}
	}

}
