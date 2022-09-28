package a2;

/**
 * 
 * @author Lap Wu
 * @version 9/21
 * @param <T>
 */
public class Node<T> {
	public T data;
	public Node<T> next;
	
	public Node(){
		next=null;
	}
	public Node(T d) {
		next=null;
		data=d;
	}
}
