class QueueArrayList<T>{

		int left = -1, right = -1;
		int arr[100];

		QueueArrayList(T data){
				arr = new int[100];
				left = 0;
				arr[left] = data;
				left = right = 0;
		}

		void enqueue(int  data){
				if(right == 99)
						System.out.println("Queue is full");
				right = right + 1;
				int index = 1;
				while(index < right){
						arr[index] = arr[index-1];

				}
				arr[0] = data;
		}

		int  dequeue(){
				if(left ==  -1){
						System.out.println("Queue is empty");
				}
				if(right == 0)
				{
						right--;
						return -1;
				}
				right = right -1;
				int index = 0;
				int data = arr[index];
				while(index < right)
						arr[index] = arr[index++];
				return data;
		}

		void dequeueAll(){
				if(right == -1)
						System.out.println("Queue is Empty");
				while(right != -1){
						System.out.println(queue.get(0));
						queue.remove(0);
						right--;
				}
		}


		public static void main(String []args){
				QueueArrayList<Integer> q = new QueueArrayList<>(Integer.valueOf(9));
				q.enqueue(10);
				q.enqueue(20);
				q.enqueue(30);
				q.enqueue(40);
				q.enqueue(50);
		}
}
