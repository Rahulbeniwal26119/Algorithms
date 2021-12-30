package sorting;

public class QuickSort{

		public static void swap(int arr[] , int i , int j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
		}

		public static void quickSort(int arr[] , int l, int h){
				int i = l+1; // if i = l, then for already sorted it gives problems
				int j = h;

				int pivot = l;
				if(l >  h)
						return ;

				while(j >= i){
						if(arr[i] > arr[pivot] && arr[j] < arr[pivot]){
								swap(arr , i , j);
						}
						else if(arr[i] <= arr[pivot]) i++;
						else if(arr[j] >=  arr[pivot]) j--;
				}
				swap(arr , pivot, j);
				quickSort(arr , l, j-1);
				quickSort(arr , j+1, h);
		}

		public static void main(String []args){
				int arr[] = {5,4,3,2,1};
				quickSort(arr, 0, arr.length-1);
				for(var i : arr) 
						System.out.println(i);
		}
}


