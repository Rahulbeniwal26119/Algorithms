interface Queue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E e);

    E first();

    E dequeue();
}

public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();
    public LinkedQueue(){};
    public int size() {
        return list.size();
}
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enqueue(E e)
    {
        list.addLast(e);
    }

    public E first() {
        return list.first();
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public static void main(String[] args) {
     LinkedQueue<Integer> q = new LinkedQueue<>();
     q.enqueue(10);
     q.enqueue(100);
     q.enqueue(1000);
     System.out.println(q.first());
     System.out.println(q.isEmpty());
     System.out.println(q.dequeue());
     System.out.println(q.dequeue());
    }

}
