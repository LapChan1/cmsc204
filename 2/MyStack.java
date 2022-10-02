package a2;

import java.util.ArrayList;
/**
 * 
 * @author Lap Wu
 *@version 9/26
 * @param <T>
 */
public class MyStack<T> implements StackInterface<T>{
	Node<T> head;
	int capacity=15; //maximum number of node 
	int size=0;		//current number of things in stack
	
	/**
	 * Default constructor
	 */
	public MyStack() {
		head=null;
	}
	
	/**
	 * Constructor
	 * @param custom stack capacity
	 */
	public MyStack(int s) {
		head=null;
		capacity=s;
	}
	
	@Override
	public boolean isEmpty() {
		return head==null;
	}

	@Override
	public boolean isFull() {
		return size==capacity ;
	}

	@Override
	public int size() {
		return size;
	}
	@Override
	public String toString() {
		String s="";
		Node<T> current = head;
		while (current!=null) {
			s= current.data.toString()+s;
			current=current.next;
		}
		return s;
	}
	@Override
	public String toString(String delimiter) {
		String s="";
		Node<T> current = head;
		while (current!=null) {
			s= current.data.toString()+delimiter+s;
			current=current.next;
		}
		if(s.length()>=2 )
			s=s.substring(0, s.length() - 1); //remove last character in the string, which should be a delimiter
		return s;
	}

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> copy=new ArrayList<T>(list.size());
		for (int i=0;i<list.size();i++) {
			T c=list.get(i); //how to deep copy the element?
			copy.add(c);
		}
		for (int i=0;i<copy.size();i++) {
			try {
				push(copy.get(i));
			} catch (StackOverflowException e) {
				break;
			}
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(this.isEmpty())
			throw new StackUnderflowException();
		
		T x=head.data;
		head=head.next;
		size--;
		return x;
	}

	@Override
	public T top() throws StackUnderflowException {
		if(this.isEmpty())
			throw new StackUnderflowException();
		
		return head.data;
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		if( this.isFull())
			throw new StackOverflowException();

		Node<T> x= new Node<T>(e);
		if(this.isEmpty()) {
			head=x;
			size++;
			return true;
		}
		x.next=head;
		head=x;
		size++;
		return true;
		
	}
	

}
