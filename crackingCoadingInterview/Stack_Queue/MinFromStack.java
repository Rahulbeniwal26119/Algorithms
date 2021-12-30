class NodeWithMin{
		int data;
		int min;

		public NodeWithMin(int v, int min){
				data = v;
				this.min = min;
		}
}

public class MinFromStack extends Stack<NodeWithMin>{

		public void push(int value) throws EmptyStackException{
				int newMin = Math.min(value, min());
				super.push(new NodeWithMin(value, newMin));
		}

		public int min() throws EmptyStackException{
				if(this.isEmpty()){
						return Integer.MAX_VALUE;	
				}else{
						return peek().min;
				}
		}

		public static void main(String []args){
				MinFromStack stack = new MinFromStack();
				try{
						stack.push(10);
						System.out.println("in push");
						stack.push(11);
						stack.push(-10);
						//System.out.println(stack.peek());
						System.out.println(stack.min());
						stack.pop();
						System.out.println(stack.min());
						stack.pop();
						System.out.println(stack.min());
						stack.pop();
						System.out.println(stack.min());
				}
				catch(Exception e){
						System.out.println(e);
				}
		}


}
