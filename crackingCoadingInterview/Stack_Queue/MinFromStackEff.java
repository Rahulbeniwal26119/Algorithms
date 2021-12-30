public class MinFromStackEff extends Stack<Integer>{

		Stack<Integer> s2;
		public MinFromStackEff(){
				s2 = new Stack<Integer>();
		}

		public void push(int value) throws EmptyStackException{
				if(value <= min())
						s2.push(value);
				super.push(value);
		}

		public Integer pop() throws EmptyStackException{
				int value = super.pop();
				if(value == min())
						if(value == min())
								s2.pop();
				return value;
		}
		
		public int min() throws EmptyStackException{
				if(s2.isEmpty()){
						return Integer.MAX_VALUE;
				} else {
						return s2.peek();
				}
		}

		public static void main(String []args){
				MinFromStackEff stack = new MinFromStackEff();
				try{
						stack.push(10);
						stack.push(11);
						stack.push(-10);
						System.out.println(stack.min());
				}
				catch(Exception e){
						System.out.println(e);
				}
		}


}

