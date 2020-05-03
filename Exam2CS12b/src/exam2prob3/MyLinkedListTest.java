package exam2prob3;


public class MyLinkedListTest {

	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		for(int i=1; i<=20; i++) {
			list.add(i);
		}
		System.out.println("list="+list);
		MyLinkedListNode<Integer> n = list.front;

		while (n != null) {
			System.out.println("n.val="+n.val+" list= "+list);
			if (n.val % 3==0) {
				n.addAfter(100);
			} else if (n.val % 5 ==0) {
				n.deleteNext();
			}
			n = n.next;
		}
		System.out.println("now using a for loop");
		for(Integer m: list) {
			System.out.print(m+",");
		}
	}

}
