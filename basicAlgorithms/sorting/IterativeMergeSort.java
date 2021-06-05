package sorting;
public class IterativeMergeSort{

		static void merge(int A[] ,int low , int mid, int high){
				int l1 = mid - low + 1;
				int l2 = high - mid ;
				int arr1[] = new int[l1];
				int arr2[] = new int[l2];
				
				for(int z=0; z<l1; z++)
				{
						arr1[z] = A[low + z];
				}
				for(int z=0; z<l2; z++){
						arr2[z] = A[mid + z + 1];
				}

				int i=0, j =0, k=low; 
				for( ; i < l1 && j < l2;){
						if(arr1[i] < arr2[j])
								A[k++] = arr1[i++];
						else
								A[k++] = arr2[j++];
				}

				while(i < l1)
						A[k++] = arr1[i++];
				while(j < l2)
						A[k++] = arr2[j++];
		}

		static void iterativeMergeSort(int A[]){
				int length = A.length;
				int p=0, mid, low, high;

				for(p = 2; p<=length; p*=2)
				{
						for(int i=0;  i + p -1 < length; i=i+p){
								low = i;
								high = i + p -1;
								mid = (low + high)/2;
								merge(A , low, mid , high);
						}
				}
				if(p/2 < length){
					merge(A , 0 , p/2-1, length-1);
				}
		}
}

