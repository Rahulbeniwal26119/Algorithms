import java.util.HashSet;
class Index{
		public int value=0;
}


class GeneralLL extends LinkedList{

		 GeneralLL(int d){
				super(d);
		}

		public int printKthToLast(Node head, int k){
				if(head == null) return 0;
				int index = printKthToLast(head.next, k) + 1;
				System.out.println(index);
				if(index == k)
						System.out.println(k + "th to last node is " + head.data);
				return index;
		}

		public void printLLReversed(Node head){
				if(head!=null){
						System.out.println(head.data);
						printLLReversed(head.next);
				}
		}


		boolean deleteNode(Node n){
				if(n == null || n.next == null)
						return false;
				Node next = n.next;
				n.data = next.data;
				n.next = next.next;
				return true;
		}

		Node partition(Node n, int x){
			Node head = null;
			Node tail = null;
			
			while(n != null){
				Node next = n.next;
				if(n.data < x){
					n.next = head;
					head = n;
				}
				else{
					tail.next = n;
					tail = n;
				}
				n = next;
			}
			tail.next = null;
			return head;
		}

		public static void main(String []args){
				GeneralLL ll = new GeneralLL(10);
				GeneralLL ld = new GeneralLL(10);
				ll.appendToLast(15);
				ll.appendToLast(9);
				ll.appendToLast(8);
				ll.appendToLast(7);
				ll.appendToLast(12);
				ll.appendToLast(13);
				ll.appendToLast(14);
				ld.head = ll.partition(ll.head,12);
				//ll.printLLReversed(ll.head);
				ll.printLLReversed(ll.head);
		}
}


