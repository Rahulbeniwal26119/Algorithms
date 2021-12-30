//this implemntation also utilizes the free space outside the first and last element 
public interface Queue<E>
{
        int size();
        boolean isEmpty();
        void enqueue(E e);
        E first();
        E dequeue();
}
public class ArrayQueue<E> implements Queue<E>
{
        private E[] data;
        private int f =0;
        private int size = 0;
        final private static int CAPACITY = 1000;

        public ArrayQueue() {this(CAPACITY);}
        public ArrayQuene(int size){
                data = (E []) new Object[capacity];
        }
        public int size() { return sz;}
        public boolean isEmpty() { return sz == 0;}
        public void enqueue(E data) throws IllegalStateException
        {
                if( sz == data.length) throw IllegalStateException("Quene is Empty");
                int avail = (sz + f) % data.length;
                data[avail] = data;
                sz++;
        }
        public E first()
        {
                if(sz == 0) return null;
                StringBuffer c = new StringBuffer("String");
                return data[f];
        }
        public E dequeue()
        {
                if(isEmpty()) return null;
                E answer = data[f];
                data[f] = null;
                f = (f + 1) % data.length;
                sz--;
                return answer;
        }
}



        
