public interface Stack<E>
{
        int size();
        boolean isEmpty();
        void push(E e);
        E top();
        E pop();
}
 class ArrayStack<E> implements Stack<E>
{
        public static final int CAPACITY = 1000;
        private E[] data;
        private int top = -1;
        
        public ArrayStack() // create stack  of default class capacity
        {
                this(CAPACITY);
        }

        public ArrayStack(int capacity)  // create stack of desired capacity 
        {
                data =  (E []) new Object[capacity];
        }

        public int size() { return (top + 1); }
        
        public boolean isEmpty() { return ( top == -1); }
        
        public void push(E e) throws IllegalStateException 
        {
                if(size() == data.length)
                        throw new IllegalStateException("State is full");
                data[++top] = e;
        }
        
        public E top()
        {
                if(top == -1) return null;
                return data[top];
        }
        
        public E pop()
        {
                if(isEmpty()) return null;
                E answer = data[top];
                data[top] = null;
                top--;
                return answer;
        }
        public static void main(String[] args)
        {
                ArrayStack<Integer> stack = new ArrayStack<Integer>();
                stack.push(10);
                stack.push(110);
                stack.push(15);
                stack.push(16);
                System.out.println(stack.pop());
                System.out.println(stack.pop());
                System.out.println(stack.top());
                System.out.println(stack.size());
        }
}




