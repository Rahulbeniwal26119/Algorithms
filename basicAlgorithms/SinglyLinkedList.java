class SinglyLinkedList<E>
{
        private static class Node<E> 
        {
                private E element;
                private Node<E> next;
         
                public Node(E d , Node<E> n)
                {
                        element = d;
                        next  = n;
                }

                public E getElement() 
                {
                        return element;
                }

                public Node<E> getNext()
                {
                        return next;
                }

                public void setNext(Node <E> n)
                {
                        next = n;
                }
        }
        private Node<E> head=null;
        int size=0;
        private Node<E> tail=null;
        public SinglyLinkedList() {}
        public int size() { return size;}
        public boolean isEmpty() { return size==0; }
        public E first()
        {
                if(size == 0) return null;
                return head.getElement();
        }
        public E last()
        {
                if(isEmpty()) return null;
                return tail.getElement();
        }

        public void addFirst(E data)
        {
                 head = new Node(data , head);
                 if(size == 0)
                         tail = head;
                 size++;
        }

        public void addLast(E data)
        {
                Node newNode = new Node<>(data , null);
                if(isEmpty()) 
                        head = newNode;
                else 
                        tail.setNext(newNode);
                tail = newNode;
                size++;
        }

        public E removeFirst()
        {
                if(isEmpty()) return null;
                E answer = head.getElement();
                head = head.getNext();
                size--;
                if(size == 0)
                         tail = null;
                return answer;
        }
	public Node<E> reverse(Node<E> head)
	{
		if(head == null || head.getNext() == null)
			return head;
		Node<E> remaining = reverse(head.getNext());
		head.getNext().getNext().setnext(head);
		head.getNext().setNext(null);
		return remaining;
	}
	int getElementAfterFromEnd(Node<E> head, int position)
	{
		Node<E> currPtr = result = head;
		int i=0;
		while(currPtr != null)
		{
			currPtr = currPtr.next;
			if( i++ > position)
			{
				result = result.getNext();
			}
		}
		return result.data;
	}
	public Node<E> removeDuplicates(Node<E> head)
	{
			Node<E> tempNode = null;
			Node<E> tempHead = head;
			tempNode = head;
			while(head.getNext() != null)
			{
				head = head.getNext();
				if(tempNode.getData() == head.getData())
				{
					tempNode.setNext(head.getNext());
				}
				else 
				{	
					tempNode = tempNode.getNext();
				}
			}
			return tempNode;
	}
	// floyd cycle algorithm 
	public boolean checkCycle(Node<E> head)
	{
		if(head == null) return null;
		Node<E> slow = head;
		Node<E> fast = head;

		while(slow != null && fast != null && fast.getNext() != null)
		{
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if(slow == fast)
				return true;
		}
		return false;
	}
	public int checkMergePoint(Node<E> head1, Node<E> head2)
	{
		Node<E> heada = head1;
		Node<E> headb = head2;

		while(heada != headb)
		{
			if(heada.next == null)
				heada = head2;
			else 
				heada = heada.getNext();
			if(headb.next == null)
				headb = head1;
			else 	
				headb = headb.getNext();
		}
		return headb.getData();
	}
		

}
