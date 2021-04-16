public class ArrayList<E> implements List<E>
{
        public static final int CAPACITY = 16;
        private E[] data;
        private int size=0;

        ArrayList() { this(CAPACITY); }

        protected void resize(int capacity)
        {
                E temp[] = (E[]) new Object[capacity];
                for(int k=0; k<size; k++)
                        temp[k] = data[k];
                data = temp;
        }

        ArrayList(int capacity) { 
                data = (E[]) new Object[capacity];
        }

        public int size() { return size;}

        public boolean isEmpty() { return size == 0;}


        public E get(int i) throws IndexOutOfBoundsException
        {
                checkIndex(i , size);
                return data[i];
        }

        public E set(int i, E e) throws IndexOutOfBoundsException
        {
                checkIndex(i, size);
                E temp = data[i];
                data[i] = e;
                return temp;
        }

        public void add(int i , E e) throws IndexOutOfBoundsException
        {
                checkIndex(i, size+1);
                if(size == data.length)
                        resize(2*data.length);
                for(int k = size-1; k >=i; k--)
                {
                        data[k] = data[k+1];
                }
                size++;
        }

        public E remove(int i) throws IndexOutOfBoundsException
        {
                checkIndex(i , size);
                E temp = data[i];
                for(int k=i; k < size-1; k++)
                {
                        data[k] = data[k+1];
                }
                size--;
                return temp;
        }

        public void  checkIndex(int i, int n) throws IndexOutOfBoundsException
        {
                if(i < 0 || i >= n)
                    throw new IndexOutOfBoundsException("Illegal Index");    
        }
}





