package exam2prob3;

import java.util.Iterator;

public class MyLinkedListIterator<T> implements Iterator<T>{
	
	MyLinkedListNode<T> position = null;
	
	MyLinkedListIterator(MyLinkedList<T> list) {
		position = list.front;
	}

	@Override
	public boolean hasNext() {
		return position != null;
	}

	@Override
	public T next() {
		T val = position.val;
		position = position.next;
		return val;
	}
	
}
