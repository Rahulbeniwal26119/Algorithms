public class LinkedList{
		Node head;
		LinkedList(int d){
				head = new Node(d);
		}

		static class Node{
				Node next = null;
				int data;

				public Node(int d){
						data = d;
				}
		}

		void appendToLast(int d){
				Node end = new Node(d);
				Node n = this.head;
				while(n.next != null)
						n = n.next;
				n.next = end;
		}

		void printLL(Node head){
				while(head != null){
						System.out.println(head.data);
						head = head.next;
				}
		}

		boolean deleteNode(Node head, int d){
				Node prevNode = head;
				while(head != null && head.data !=d){
						prevNode = head;
						head = head.next;
				}
				if(head == null)  //not found case 
						return false;

				// element is first element 
				if(prevNode == this.head && head == this.head){
						this.head = this.head.next;
						return true;
				}

				//remaining case 
				prevNode.next = head.next;
				return true;
		}


}

