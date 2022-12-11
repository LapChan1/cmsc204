package a6;

/**
 * 
 * @author Lap Wu
 *
 */
public class Road implements Comparable<Road> {
	private Town t1,t2;
	private int distance;
	private String name;
	
	public Road(Town t1,Town t2, int weight,String name) {
		this.t1=t1;
		this.t2=t2;
		this.distance=weight;
		this.name=name;
	}
	
	/**
	 *  constructor with weight = 1
	 */
	public Road(Town t1,Town t2, String name) {
		this.t1=t1;
		this.t2=t2;
		this.distance=1;
		this.name=name;
	}

	@Override
	/**
	 * @returns 0 if the road names are the same, a positive or negative number if the road names are not the same
	 */
	public int compareTo(Road r) {
		return this.name.compareTo(r.name);
	}
	
	/**
	 * 
	 * @param town 
	 * @return true only if the edge contains the given town
	 */
	public boolean contains(Town t) {
		if(t1.equals(t) || t2.equals(t))
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * @param road to be compared to
	 * @returns true if each of the ends of the road r is the same as the ends of this road. 
	 */
	@Override
	public boolean equals(Object road) {
		Road r= (Road) road;
		if(this.t1.equals(r.t1) &&this.t2.equals(r.t2))
			{return true;}
		else if(this.t1.equals(r.t2) && this.t2.equals(r.t1)) {
			return true;}
		else 
		{return false;}
		
	}
	
	/**
	 * 
	 * @return town 2
	 */
	public Town getDestination() {
		return t2;
	}
	
	/**
	 * 
	 * @return road name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return town 1
	 */
	public Town getSource() {
		return t1;
	}
	
	/**
	 * 
	 * @return distance
	 */
	public int getWeight() {
		return distance;
	}
	
	public String toString() {
		return "Source: "+t1.getName()+
				" Destination: "+t2.getName()+
				" Distance: "+ Integer.toString(distance)+
				" Name: "+name;
	}
	
}
