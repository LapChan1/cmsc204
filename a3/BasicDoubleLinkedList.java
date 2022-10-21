package a3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Lap Wu
 * @version 10/20
 * @param <T>
 */
public class BasicDoubleLinkedList<T> {
	protected Node<T> first,last;
	protected int size;
	
	public BasicDoubleLinkedList(){
		first=last=null;
		size=0;
	}
	
	/**
	 * add element to the end of list and update size
	 * @param data
	 */
	public void addToEnd(T data) {
		Node<T> x =new Node<T>(data);
		if(last==null)
			first=last=x;
		else if(first ==last) {
			last=x;
			last.prev=first;
			first.next=last;
		}
		else {
			last.next=x;
			x.prev=last;
			last=x;
		}
		
		size++;
	}
	/**
	 * add element to the front of list and update size
	 * @param data
	 */
	public void addToFront(T data) {
		Node<T> x =new Node<T>(data);
		if(first==null)
			first=last=x;
		else if(first ==last) {
			first=x;
			first.next=last;
			last.prev=first;
		}
		else {
			first.prev=x;
			x.next=first;
			first=x;
		}
		
		size++;
	}
	
	/**
	 * return the first item in the list
	 * @return first item in list
	 */
	public T getFirst() {
		return first.data;
	}
	
	/**
	 * return the last item in the list
	 * @return last item in list
	 */
	public T getLast() {
		return last.data;
	}
	/**
	 * return the number of nodes in the list
	 * @return amount of nodes in the list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * return an object of the DoubleLinkedListIterator.
	 * @return a DoubleLinkedListIterator.
	 */
	public DoubleLinkedListIterator<T> iterator(){
		DoubleLinkedListIterator<T> it= new DoubleLinkedListIterator<T>(first,size);
		return it;
	}
	
	/**
	 * remove the first instance of targetData in the list
	 * @param targetData - item to be removed
	 * @param comparator - compare data
	 * @return the first node containing targetData
	 */
	public Node<T> remove(T targetData, Comparator<T> comparator) {
		if (comparator.compare(targetData, first.data)==0) {
			Node<T> x=first;
			if(first.next!=null) {
				first.next.prev=null;
				first=first.next;}
			else {
				last=first=null;
			}
			size--;
			return x;
			}
		

		DoubleLinkedListIterator<T> it = iterator();
		while (it.hasNext() && comparator.compare(targetData, it.current.data)!=0) {
			it.next();
		}
		
		if(comparator.compare(targetData, it.current.data)==0) {
			if (it.current==last){
				Node<T> x =last;
				last=last.prev;
				last.next=null;
				size--;
				return x;
			}
			
			it.current.prev.next=it.current.next;
			it.current.next.prev=it.current.prev;
			size--;
			return it.current;
		}
		return null;
	}
	
	/**
	 * removes and return the first element from the list
	 * @return first item in the list
	 */
	public T retrieveFirstElement() {
		T x=first.data;
		if (first==last)
			first=last=null;	
		
		
		first=first.next;
		first.prev=null;
		
		return x;
	}
	
	/**
	 * removes and return the last element from the list
	 * @return last item in the list
	 */
	public T retrieveLastElement() {
		T x=last.data;
		if (first==last)
			first=last=null;	
		
		
		last=last.prev;
		last.next=null;
		
		return x;
	}
	
	/**
	 * Returns an arraylist of all the items in the Double Linked list
	 * @return all items in the list in arraylist form
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<T>();
		Node<T> x=first;
		while(x!=null) {
			list.add(x.data);
			x=x.next;
		}
		return list;
	}
	
	protected class Node<T>{
		T data;
		Node<T> prev,next;
		public Node(){
			data=null;
			prev=next=null;
		}
		public Node(T d){
			data=d;
			prev=next=null;
			
		}
	}
	
	
	protected class DoubleLinkedListIterator<T> implements ListIterator<T>{
		int size,c;
		Node<T> current;
		Node<T> lastAccess;
		
		public DoubleLinkedListIterator(Node<T> n,int s) {
			c=0;
			current=n;
			size= s;
		}
		
		@Override
		public boolean hasNext() {
			return c<size;
		}
		
		@Override
		public T next() throws NoSuchElementException {
			if(!hasNext())
				throw new NoSuchElementException();
			lastAccess=current;
			T x=lastAccess.data;
			if(current.next!=null)
				current=current.next;
			c++;
			return x;
		}

		@Override
		public boolean hasPrevious() {
			return c>0;
		}

		@Override
		public T previous() throws NoSuchElementException{
			if(!hasPrevious())
				throw new NoSuchElementException();
			lastAccess=current;
			T x=lastAccess.data;
			if(current.prev!=null)
				current=current.prev;
			c--;
			return x;
		}

		@Override
		public int nextIndex()throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex()throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove()throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(Object e)throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(Object e) throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		}
		
	}
}
