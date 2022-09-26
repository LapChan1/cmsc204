package a;
/**
 * 
 * @author Lap Wu
 * Sum an array of integers using recursion
 */
public class ArraySum {
	/**
	 * 
	 * @param a - integer array to be sum
	 * @param index - position of the element to be added
	 * @return sum of the integer array
	 */
	public int sumOfArray(Integer[] a,int index ) {
		if(index<0)
			return 0;
		return a[index]+sumOfArray(a,--index);
	}
}
