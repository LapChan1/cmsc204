package a6;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface {
	Graph townGraph;
	
	public TownGraphManager() {
		townGraph=new Graph();
	}
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		//TODO
		Town t1=new Town(town1);
		Town t2=new Town(town2);
		townGraph.addEdge(t1, t2, weight, roadName);
		return townGraph.containsEdge(t1, t2);
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town t1=new Town(town1);
		Town t2=new Town(town2);
		Road r =townGraph.getEdge(t1,t2);
		if(r!=null)
			return r.getName();
		return null;
	}

	@Override
	public boolean addTown(String v) {
		Town t = new Town(v);
		return townGraph.addVertex(t);
	}

	@Override
	public Town getTown(String name) {
		return townGraph.getVertex(name);
	}

	@Override
	public boolean containsTown(String v) {
		Town t = new Town(v);
		return townGraph.containsVertex(t);
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		return townGraph.containsEdge(t1, t2);
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roadNameList= new ArrayList<String>();
		for(Road r:townGraph.edgeSet())
			roadNameList.add(r.getName());
		Collections.sort(roadNameList);
		return roadNameList;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town t1=new Town(town1);
		Town t2=new Town(town2);
		if(townGraph.containsEdge(t1, t2)) {
			townGraph.removeEdge(t1, t2, townGraph.getEdge(t1, t2).getWeight(), road);
			return true;}
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		Town t =new Town(v);
		
		if(townGraph.containsVertex(t)) {
			//remove all road connecting to town t
			for(Road r: townGraph.edgeSet()) {
				if(r.contains(t)) {{
					townGraph.removeEdge(r.getSource(), r.getDestination(), r.getWeight(), r.getName());}
				}
			}
			
			townGraph.removeVertex(t);
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> townNameList= new ArrayList<String>();
		for(Town t:townGraph.vertexSet())
			townNameList.add(t.getName());
		Collections.sort(townNameList);
		return townNameList;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void fileInput(File f) {
		//TODO
	}
}
