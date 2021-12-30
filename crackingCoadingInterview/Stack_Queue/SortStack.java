class Stack<T extends Integer>{
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

		void sort(Stack<T> s) throws EmptyStackException{
				Stack<T> r = new Stack<>();
				while(!s.isEmpty()){
						T tmp = s.pop();
						while(!r.isEmpty() && r.peek() > tmp){
								s.push(r.pop());
						}
						r.push(tmp);
				}

				while(!r.isEmpty()){
						s.push(r.pop());
				}
		}
		

		public boolean isEmpty(){
				return top == null;
		}
}

class Run{

		public static void main(String ...args){

				Stack<Integer> stack = new Stack<>();
				try{
				stack.push(10);
				stack.push(8);
				stack.push(11);
				stack.push(15);
				stack.push(9);

				stack.sort(stack);
				while(!stack.isEmpty()){
						System.out.println(stack.pop());
				}
				}
				catch(Exception e){
				System.out.println(e);
				}

		}
}



				

