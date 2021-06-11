import java.util.HashSet;
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
						printLLReversed(head.next);
						System.out.println(head.data);
				}
		}


		public static void main(String []args){
				GeneralLL ll = new GeneralLL(10);
				ll.appendToLast(12);
				ll.appendToLast(13);
				ll.appendToLast(14);
				ll.appendToLast(15);
				ll.printLL(ll.head);
				ll.printKthToLast(ll.head,3);
				ll.printLL(ll.head);
				ll.printLLReversed(ll.head);
		}
}


