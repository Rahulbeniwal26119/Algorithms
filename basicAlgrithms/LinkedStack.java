 interface Stack<E>
{
        int size();
        boolean isEmpty();
        void push(E e);
        E pop();
        E top();
}
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
}
public class LinkedStack<E> implements Stack<E> 
{
        private SinglyLinkedList<E> list = new SinglyLinkedList<>();
        public LinkedStack() {}
        public int size() { return list.size(); }
        public boolean isEmpty() { return list.isEmpty(); }
        public void push(E element) { list.addFirst(element);}
        public E top() { return list.first(); }
        public E pop() { return list.removeFirst(); }

        public static void main(String [] args)
        {
                LinkedStack<Integer> ls = new LinkedStack<>();
                ls.push(11);
                ls.push(12);
                ls.push(13);
                ls.push(14);
                System.out.println(ls.pop());
                System.out.println(ls.pop());
                System.out.println(ls.pop());
                System.out.println(ls.pop());
                ls.push(13);
                System.out.println(ls.pop());
                System.out.println(ls.isEmpty());
        }
}




