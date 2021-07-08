import java.util.*;

public class Practice {

	public static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next = null;
		}

	}

	Node head;
	Node tail;

	public Practice(int data) {
		head = new Node(data);
		head.next = null;
		tail = head;
	}

	public static int length(Node head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public void insert(int data) {
		Node temp = new Node(data);
		tail.next = temp;
		tail = temp;
		temp.next = null;

	}

	public void traverse(Node temp) {
		while (temp != null) {
			System.out.print(temp.data + ' ');
			temp = temp.next;
		}
	}

	public void traverse() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public Node getHead() {
		return head;
	}

	void deleteDups(Node node) {
		HashSet<Integer> set = new HashSet<>();
		Node previous = null;
		while (node != null) {
			if (set.contains(node.data)) {
				previous.next = node.next;
			} else {
				set.add(node.data);
				previous = node;
			}
			node = node.next;
		}
	}

	int nthToLast(Node node, int k) {
		if (head == null)
			return 0;
		int index = nthToLast(head.next, k) + 1;
		if (index == k)
			System.out.println(k + " th to last " + head.data);
		return index;

	}

	class Index {
		public int value = 0;
	}

	Node addLists(Node l1, Node l2, int carry) {

		if (l1 == null && l2 == null && carry == 0)
			return null;

		Node result = new Node(0);
		int value = carry;

		if (l1 != null)
			value += l1.data;
		if (l2 != null)
			value += l2.data;

		result.data = value % 10;

		if (l1 != null || l2 != null) {
			Node more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.next = more;
		}
		return result;
	}

	static boolean isPalindrome(Node head){
			Node reversed = reverseAndClone(head);
			return isEqual(head, reversed);
	}

	static Node  reverseAndClone(Node node){
			Node head = null;
			while(node != null){
					Node n = new Node(node.data);
					n.next = head;
					head = n;
					node = node.next;
			}
			return head;
	}
	
	static boolean  isEqual(Node l1, Node l2){
			while(l1 != null && l2 != null){
					if(l1.data != l2.data)
							return false;
					l1 = l1.next;
					l2 = l2.next;
			}
			return l1 == null && l2 == null;
	}

	public static void main(String... args) {
		Practice ll = new Practice(1);
		Practice ll2 = new Practice(5);
		Practice result = new Practice(100);
		ll.insert(0);
		ll.insert(2);
		ll.insert(0);
		ll.insert(1);
		ll2.insert(1);
		ll2.insert(2);
		ll.traverse();
		ll2.traverse();

		System.out.println(isPalindrome(ll.head));
	}
}
