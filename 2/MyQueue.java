package a2;

import java.util.ArrayList;
/**
 * 
 * @author Lap Wu
 * @version 9/26
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T>{
	Node<T> head, tail;
	int capacity=15; //maximum number of node 
	int size=0;		//current number of things in stack
	
	/**
	 * default constructor
	 */
	public MyQueue() {
		head=tail=null;
	}
	
	/**
	 * Constructor
	 * @param custom stack capacity
	 */
	public MyQueue(int s) {
		head=tail=null;
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
	public T dequeue() throws QueueUnderflowException {
		if(this.isEmpty()) {
			throw new QueueUnderflowException();
		}
		T x = head.data;
		head=head.next;
		size--;
		return x;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(this.isFull()) {
			throw new QueueOverflowException();
		}

		Node<T> x= new Node<T>(e);
		if (this.isEmpty()) {
			head=x;
			tail=x;
			size++;
			return true;
		}
		tail.next=x;
		tail=x;
		size++;
		return true;
	}

	/**
	 * basic toString method
	 */
	public String toString() {
		String s="";
		Node<T> current = head;
		while (current!=null) {
			s+= current.data.toString();
			current=current.next;
		}
		return s;
	}
	
	@Override
	public String toString(String delimiter) {
		String s="";
		Node<T> current = head;
		while (current!=null) {
			s= s+delimiter+current.data.toString();
			current=current.next;
		}
		if(s.length()>=2 )
			s=s.substring(1, s.length()); //remove first character in the string, which should be a delimiter
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
				enqueue(copy.get(i));
			} catch (QueueOverflowException e) {
				break;
			}
		}
	}

}
