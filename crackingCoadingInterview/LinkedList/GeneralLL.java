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
						printLLReversed(head.next);
						System.out.println(head.data);
				}
		}

		public Node kthToLast(Node node, int k){
				Index idx = new Index();
				return kthToLast(head, k , idx);
		}

		Node kthToLast(Node head, int k, Index  idx){
				if(head == null)
						return null;
				Node node = kthToLast(head.next, k , idx);
				if(node == null)
						System.out.println("null");
				else 
						System.out.println(node.data);

				idx.value+=1;
				if(idx.value == k)
						return head;
				return node;
		}



		public static void main(String []args){
				GeneralLL ll = new GeneralLL(10);
				ll.appendToLast(12);
				ll.appendToLast(13);
				ll.appendToLast(14);
				ll.appendToLast(15);
				System.out.println(ll.kthToLast(ll.head, 3).data);
		}
}


