import java.util.HashSet;
class GeneralLL extends LinkedList{

		 GeneralLL(int d){
				super(d);
		}

	



		public static void main(String []args){
				GeneralLL ll = new GeneralLL(10);
				ll.appendToLast(11);
				ll.appendToLast(11);
				ll.appendToLast(11);
				ll.appendToLast(11);
				ll.printLL(ll.head);
				ll.deleteDupNoBuffer(ll.head);
				ll.printLL(ll.head);
		}
}


