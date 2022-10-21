package a3;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;

import a3.BasicDoubleLinkedList.DoubleLinkedListIterator;
import a3.BasicDoubleLinkedList.Node;

/**
 * 
 * @author Lap Wu
 * @version 10/20
 * @param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	Node<T> first,last;
	int size;
	Comparator<T> comp;
	
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		super();
		comp=comparator;
	}
	
	public DoubleLinkedListIterator<T> iterator(){
		DoubleLinkedListIterator<T> it= new DoubleLinkedListIterator<T>(first,size);
		return it;
	}
	
	/**
	 * add node to list
	 * @param data
	 */
	public void add(T data) {
		Node<T> x =new Node<T>(data);
		if(last==null)
			first=last=x;
		else {
			first.prev=x;
			x.next=first;
			first=x;
		}
		sort();
		size++;
	}
	
	/**
	 * bubble sort list
	 */
	public void sort() {
	    // nothing to sort
	    if (first == null)
	        return;
		
		int sortCount;
		Node<T> n;
	    do {
		    sortCount=0;
		    n=first;
		    while(n.next!=null) {
			    if (comp.compare(n.data,n.next.data)>0)
		        {
			    	T t=n.data;
			    	n.data=n.next.data;
			    	n.next.data=t;
			    	sortCount++;
		        }
			    n=n.next;
		    }
		}while(sortCount!=0);
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
		sort();
		return null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}

	public void addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
}
