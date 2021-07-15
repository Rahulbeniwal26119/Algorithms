public class Stack<T>{
		private int s=0;
		private static class StackNode<T>{
				private T data;

				private StackNode<T> next;

				public StackNode(T data){
						this.data = data;
				}
		}

		private StackNode<T> top;

		public T pop() throws EmptyStackException{
				if(top == null)
						throw new EmptyStackException();
				s--;
				T item = top.data;
				top = top.next;
				return item;
		}

		public void push(T data){
				s++;
				StackNode<T> t = new StackNode<>(data);
				t.next = top;
				top = t;
		}

		public T peek() throws EmptyStackException{
				if(top == null)
						throw new EmptyStackException();
				return top.data;
		}

		public int size(){
				return s;
		}


		public boolean isEmpty(){
				return top == null;
		}
}

