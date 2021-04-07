//this implemntation also utilizes the free space outside the first and last element 
public interface Queue<E>
{
        int size();
        boolean isEmpty();
        void enqueue(E e);
        E first();
        E dequeue();
}
class ArrayQueue<E> implements Queue<E>
{
        private E[] data;
        private int f = 0; // index of the front element
        private int sz= 0; // current number of element 
        private static  final int CAPACITY = 1000;
        


        public ArrayQueue(int capacity)
        { data = (E [] ) new Object[capacity];}
        
        public ArrayQueue()
        { this(CAPACITY);}

        public int size()
        {
                return sz;
        }
        public boolean isEmpty()
        {
                return sz==0;
        }
        public void enqueue(E e) throws IllegalStateException 
        {
                if(sz == data.length) throw new IllegalStateException("Queue is full");
                int avail = (f + sz) % data.length; // find the next empty space 
                data[avail] = e;
                sz++;
        }
        public E first()
        {
                if(isEmpty()) return null;
                return data[f];
        }
        public E dequeue()
        {
                if(isEmpty()) return null;
                E answer = data[f];
                data[f] = null;
                f = (f + 1) % data.length ;  // find the next first index 
                sz--;
                return answer;
        }
        public static void main(String []args)
        {
                ArrayQueue<Integer> q = new ArrayQueue<>();
                q.enqueue(10);
                q.enqueue(100);
                q.enqueue(1000);
                System.out.println(q.first());
                System.out.println(q.dequeue());
                System.out.println(q.dequeue());
                System.out.println(q.isEmpty());
        }
}
