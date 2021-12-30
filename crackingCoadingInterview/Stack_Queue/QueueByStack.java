class Queue<T>{

		Stack<T> stackNewest, stackOldest;

		public Queue(){
				stackNewest = new Stack<T>();
				stackOldest = new Stack<T>();
		}

		public int size(){
				return stackNewest.size() + stackOldest.size();
		}

		public void add(T value){
				stackNewest.push(value);
		}

		private void shiftStack() throws EmptyStackException{
				if(stackOldest.isEmpty()){
						while(!stackNewest.isEmpty())
								stackOldest.push(stackNewest.pop());
				}
		}

		public T peek() throws EmptyStackException{
				shiftStack();
				return stackOldest.peek();
		}

		public T remove() throws EmptyStackException{
				shiftStack();
				return stackOldest.pop();
		}

		public static void main(String []args){
				Queue<Integer> q = new Queue<>();
				try{
				q.add(10);
				q.add(12);
				q.add(13);
				q.add(14);
				System.out.println(q.peek());
				System.out.println(q.remove());
				System.out.println(q.remove());
				System.out.println(q.remove());
				}
				catch(Exception e){}
		}
}
