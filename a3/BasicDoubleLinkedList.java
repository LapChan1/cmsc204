package a3;

import java.util.ListIterator;

/**
 * 
 * @author Lap Wu
 * @version
 * @param <T>
 */
public class BasicDoubleLinkedList<T> {
	protected Node<T> first,last;
	protected int size;
	
	public BasicDoubleLinkedList(){
		first=last=null;
		size=0;
	}
	
	protected class Node<T>{
		T data;
		Node prev,next;
		public Node(){
			data=null;
			prev=next=null;
		}
		public Node(T d){
			data=d;
			prev=next=null;
			
		}
	}
	
	
	protected class DoubleLinkedListIterator<T> implements ListIterator{
		Node<T> current;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasPrevious() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Object previous() {
			// TODO Auto-generated method stub
			return null;
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
