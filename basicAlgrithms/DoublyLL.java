public class DoublyLL<E>
{
	private static class Node<E> 
	{
		private E data;
		private Node<E> next;
		private Node<E> prev;
		public Node(E e, Node<E> p, Node<E> n)
		{
			data = e;
			next = n;
			prev = p;
		}

		public E getData() {return data;}
		public Node<E> getPrev() { return prev;}
		public Node<E> getNext() { return next;}
		public void setPrev(Node<E> p) { prev = p;}
		public void setNext(Node<E> n) { next = n;}
	}
	private Node<E> header;
	private Node<E> trailer;
	private int size=0;
	public DoublyLL(){
		header = new Node<>(null , null , null); // prev is not defined till now 	
		trailer = new Node<>(null , header , null);
		header.setNext(trailer);
	}
	public int size() { return size;}
	public isEmpty() { return size == 0; }
	public E first()
	{
		if(isEmpty())
			return null;
		return header.getNext().getData();
	}
	public E last()
	{
		if(isEmpty()) return null;
		return trailer.getPrev().getData();
	}
	public void addFirst(E e) 
	{
		addBetween(e , header , header.getNext());
	}
	public void addLast(E e)
	{
		addBeteen(e , trailer.getPrev(), trailer);
	}
	public E removeFirst()
	{
		if(isEmpty())
			return null;
		return remove(header.getNext());
	}
	public E removeLast()
	{
		if(isEmpty())
			return null;
		return remove(trailer.getPrev());
	}
	public void addBetween(E e, Node<E> pred , Node<E> succ)
	{
		Node<E> newNode = new Node<>(e , pred , succ);
		pred.setNext(newNOde);
		succ.getPrev(newNode);
		size++;
	}
	private E remove(Node <E> node)
	{
		Node<E> pred = node.prev;
		Node<E> succ = node.succ;
		pred.setNext(succ);
		succ.setPrev(pred);
		--size;
		return node.getElement();
	}


		pred.setNext(

}


