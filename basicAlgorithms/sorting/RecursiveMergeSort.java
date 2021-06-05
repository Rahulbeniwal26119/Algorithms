package sorting;
public class RecursiveMergeSort extends IterativeMergeSort{

		public static void recursiveMergeSort(int [] arr, int low , int high){
				if(low >= high)
						return;
				int mid = (low + high)/2;
				recursiveMergeSort(arr , low , mid);
				recursiveMergeSort(arr , mid+1 , high);
				merge(arr, low , mid , high);
		}
}

