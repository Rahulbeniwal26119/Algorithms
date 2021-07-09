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

	public Node insert(int data) {
		Node temp = new Node(data);
		tail.next = temp;
		tail = temp;
		temp.next = null;
		return temp;

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

	static Node findIntersection(Node list1, Node list2){
			if(list1 == null || list2 == null) return null;

			Result result1 = getTailAndSize(list1);
			Result result2 = getTailAndSize(list2);

			if(result1.tail != result2.tail)
					return null;

			Node shorter = result1.size < result2.size ? list1 : list2;
			Node longer = result1.size < result2.size ? list2 : list1;

			longer = getKNode(longer, Math.abs(result1.size - result2.size));
			while(shorter != longer)
			{
					shorter = shorter.next;
					longer = longer.next;
			}

			return longer;
	}

	public static class Result{
			public Node tail;
			public int size;
			public Result(Node tail, int size){
					this.tail = tail;
					this.size = size;
			}
	}

	public  void linkLast(Node next){
			tail.next = next;
			tail = next;
	}

	static public void linkTwo(Node one, Node two)
	{
			one.next = two;
	}



	static Result getTailAndSize(Node head){
			if(head == null) return null;
			int size = 1;
			Node current = head;
			while(current.next != null)
			{
					size++;
					current = current.next;
			}
			return new Result(current, size);
	}

	static Node getKNode(Node head, int k){
			Node current = head;
			while(k > 0 && current != null){
					current = current.next;
					k--;
			}
			return current;
	}

	static Node findBeginning(Node head){
			Node fast = head;
			Node slow = head;

			while(fast != null && fast.next != null){
					slow = slow.next;
					fast = fast.next.next;
					if(slow == fast)
							break;
			}

			System.out.println("Collision point is " + slow.data);

			if(fast == null || fast.next == null)
					return null;

			slow = head;
			while(slow != fast){
					slow = slow.next;
					fast = fast.next;
			}

			return fast;
	}

	
	public static void main(String... args) {
		Practice ll = new Practice(1);
		ll.insert(2);
		Node link  = ll.insert(3);
		ll.insert(4);
		Node temp = ll.insert(5);
		linkTwo(temp, link);
		System.out.println(findBeginning(ll.head).data);
	}
}
