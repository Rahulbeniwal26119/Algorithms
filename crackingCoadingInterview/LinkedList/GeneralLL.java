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

		public static  void printLLReversed(Node head){
				if(head!=null){
						System.out.println(head.data);
						printLLReversed(head.next);
				}
		}

		Node  addLists(Node l1, Node l2, int carry){
				if(l1 == null && l2 == null && carry == 0)
						return null;
				LinkedList result = new LinkedList(0);
				Node head = result.head;

				int value = carry;

				if(l1 != null){
						value+=l1.data;
				}
				if(l2 != null){
						value+=l2.data;
				}
				head.data = value % 10;
				if(l1 != null || l2 != null)
				{
						// System.out.println(l1.data + " " + l2.data);
						Node more = addLists(l1 == null ? null : l1.next, 
										l2 == null ? null : l2.next , value > 10 ? 1 : 0);
						// System.out.println(l1.data + " " + l2.data + "at last");
						// if(more != null){
						//System.out.println(more.data + " data ");
						printLLReversed(head);
						result.appendToLast(more.data);
						//}
				}
				return result.head;
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
				GeneralLL ll = new GeneralLL(6);
				GeneralLL ld = new GeneralLL(2);
				ll.appendToLast(1);
				ll.appendToLast(7);
				ld.appendToLast(9);
				ld.appendToLast(5);

				Node result = ld.addLists(ll.head, ld.head, 0);
				//ll.printLLReversed(ll.head);
				// ll.printLLReversed(result);
		}
}


