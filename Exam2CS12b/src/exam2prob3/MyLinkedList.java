package exam2prob3;

import java.util.Iterator;
import java.lang.Iterable;

public class MyLinkedList<T> implements Iterable<T>{
	public MyLinkedListNode<T> front;
	
	
	public MyLinkedList() {
		front = null;
	}
	
	/**
	 * add the integer v to the front of the list ..
	 * @param v
	 */
	public void add(T v) {
		MyLinkedListNode<T> n = new MyLinkedListNode<T>(v);
		n.next = this.front;
		this.front = n;
	}
	
	public void deleteFirst() {
		this.front = this.front.next;
	}
	

	
	/**
	 * iterate through the list and create a string of form "[1,5,2,6,3]"
	 */
	public String toString() {
		String s = "[";
		MyLinkedListNode<T> n = this.front;
		if (n==null) {
			return "[]";
		}
		while (n.next != null) {
			s += n.val+", ";
			n = n.next;
		}
		return s + n.val+"]";
	}
	
	public Iterator<T> iterator() {
		return new MyLinkedListIterator<T>(this);
	}

}

