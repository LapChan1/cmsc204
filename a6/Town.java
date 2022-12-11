package a6;

/**
 * 
 * @author Lap Wu
 *
 */
public class Town implements Comparable<Town> {
	private String name;
	public int[] paths;
	
	/**
	 * 
	 */
	public Town(String name) {
		this.name=name;
	}
	
	/**
	 * copy constructor
	 * @param town to be copied
	 */
	public Town(Town t) {
		this.name = t.name;
	}
	
	@Override
	/**
	 * @returns 0 if names are equal, a positive or negative number if the names are not equal
	 */
	public int compareTo(Town t) {
		return this.name.compareTo(t.name);
	}
	
	/**
	 * 
	 * @param town
	 * @return true if the town names are equal, false if not
	 */
	public boolean equals(Town t) {
		if (t.name.equals(this.name))
			return true;
		else 
			return false;
	}
	
	/**
	 * 
	 * @return town name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @returns town name
	 */
	public String toString() {
		return getName();
	}

	
}
