// 1->2->3 + 3->4 = 1->2->3 + 0->3->4 = 
Node addLists(Node l1, Node l2, int carry){

		if( l1 == null && l2 == null && carry == 0)
				return null;

		Node result = new Node(0); // providing default value for a node  
		int value  = carry;

		if(l1 != null)
				value += l1.data;
		if(l2 != null)
				value += l2.data;

		result.data = value % 10;

		if(l1 != null || l2 != null){
				Node more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
		result.next = more;
		}
		return result;
}
class PartialSum{
		public Node sum = null;
		public int carry = 0;
}
Node addLists(Node l1, Node l2){
		int len1 = length(l1);
		int len2 = length(l2);

		if(len1 < len2){
				l1 = padList(l1, len2 - len1);
		}
		else{
				l2 = padList(l2, len1 - len2);
		}

		Partial sum = addListHelper(l1, l2);
		if(sum.carry == 0)
				return sum.sum;
		else{
				Node result = insertBefore(sum.sum, sum.carry);
				return result;
		}
}

PartialSum addListHelper(Node l1, Node l2){
		if(l1 == null && l2 == null)
		{
				PartialSum sum = new PartialSum();
				return sum;
		}
		PartialSum sum = addListHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		Node fullResult = insertBefore(sum.sum, val % 10);
		sum.sum = fullResult;
		sum.carry = val/10;
		return sum;
}
Node padList(Node ll, int padding){
		Node head = ll;
		for(int i=0; i < padding; i++){
				head = insertBefore(head, 0);
		}
		return head;
}

Node insertBefore(Node list, int data){
		Node node = new Node(data);
		if(list != null){
				node.next = list;
		}
		return node;
}


