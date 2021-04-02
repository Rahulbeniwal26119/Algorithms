public interface Stack<E>
{
        int size();
        boolean isEmpty();
        void push(E e);
        E pop();
        E top();
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
                System.out.println(ls.top());
                System.out.println(ls.pop());
                System.out.println(ls.isEmpty());
        }
}




