package exam2prob3;


public class MyLinkedListNode<T> {
	public T val;
	public MyLinkedListNode<T> next;
	
	public MyLinkedListNode(T val) {
		this.val=val;
		this.next = null;
	}
	
	/**
	 * delete the node following this node
	 */
	public void deleteNext() {
		// write your code here
		this.next = this.next.next;
	}
	
	/**
	 * add the node with value v after this node
	 * @param v
	 */
	public void addAfter(T v) {
		MyLinkedListNode<T> tempt = new MyLinkedListNode<>(v);
		tempt.next = this.next;
		this.next = tempt;
		return;
	}
}