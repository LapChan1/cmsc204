package a4;

import java.io.IOException;
import java.util.ArrayList;

public class CourseDBStructure implements CourseDBStructureInterface{
	private ArrayList<Node> table;
	private int size; //table size
	//list of all prime below 1000
    private int[] prime = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
 
	/**
	 * get a table size given n courses
	 * @param n - estimated numbers of course
	 */
	public CourseDBStructure(int n) {
		double load=1.5;
		double num=n/load;
		int k= (int) ((num-3)/4);
		boolean isPrime =false;

		do {
			size=++k*4 +3;
			for (int i=0; i<prime.length;i++) {
				if(prime[i]>size || prime[i]==size) { // size is indivisible by any prime lesser than it, so it is prime
					isPrime=true;
					break;}
				else if(size%prime[i]==0)
					break;//size isn't prime
			}
		}while(!isPrime);
		
		table=new ArrayList<Node>(size);//initialize table entry
		for(int i=0; i<size;i++) {
			table.add(null);
		}
	}
	
	/**
	 * For testing 
	 * @param test - string for testing
	 * @param size - hashtable size
	 */
	public CourseDBStructure(String test, int size) {
		this.size=20;
		table=new ArrayList<Node>(this.size);
		
		table=new ArrayList<Node>(size);//initialize table entry
		for(int i=0; i<size;i++) {
			table.add(null);}
	}

	@Override
	public void add(CourseDBElement element) {
		int key = element.hashCode()%size;
		while(key>size)
			key = key%size;
		Node x =new Node(element);
		if (table.get(key)==null)
			table.add(key, x);
		else {
			Node current=table.get(key);
			do {
				if(element.compareTo(current.data)==0) {
					table.set(key, x); // update if CRN is same
					return; // stop method if item is already in 
					}
				current=current.next;
			}while(current!=null);
			table.get(key).next=x;// bucket the element if something is already there
		}
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		int key = String.valueOf(crn).hashCode()%size;
		while(key>size)
			key = key%size;
		if(table.get(key)!=null) {
			CourseDBElement a= table.get(key).data;
			if(a.getCRN()!=crn) {
				Node x=table.get(key).next;//search for bucketed node if crn doesnt match
				while(x!=null) {
					a=x.data;
					if(a.getCRN()==crn)
						return a;
					x=x.next;
				}
				return null;
			}
			return a;
			}
		else {
			throw new IOException();}
	}

	@Override
	public ArrayList<String> showAll() {
		// TODO Auto-generated method stub
		ArrayList<String> x=new ArrayList<String>();
		for (int i=0;i<size;i++) {
			if(table.get(i)!=null) {
				x.add(0,"\n"+table.get(i).data.toString());
				Node bucketedNode=table.get(i).next;
				if(bucketedNode!=null) {//add bucketed node if available
					x.add(0,bucketedNode.data.toString());
					bucketedNode=bucketedNode.next;
					while(bucketedNode!=null){
						x.add(0,bucketedNode.data.toString());
					}
				}
				}
		}
		return x;
	}

	@Override
	public int getTableSize() {
		return size;
	}
	
	class Node{
		CourseDBElement data;
		Node next;
		
		Node(CourseDBElement d){
			data=d;
		}
	}

}
