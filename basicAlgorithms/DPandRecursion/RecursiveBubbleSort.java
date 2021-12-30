public class RecursiveBubbleSort{

		static void swap(int arr[], int i, int j){
				int a = arr[i];
				int b = arr[j];
				a ^=b;
				b ^=a;
				a ^=b;
				arr[i] = a;
				arr[j] = b;
		}

		static void bubbleSortRecursive(int arr[], int n){
				if(n <= 1)
						return;
				for(int j=0; j < n - 1; j++){
						if(arr[j] > arr[j+1])
								swap(arr,j, j+1);
				}
				bubbleSortRecursive(arr , n-1);
		}

		public static void main(String args[]){
				int arr[] = {5,4,3,2,1};
				bubbleSortRecursive(arr, arr.length);
				for(var i : arr)
						System.out.print(i + " ");
		}
}


