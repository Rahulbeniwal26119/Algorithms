package sorting;
public class SelectionSort{

		public static void selectionSort(int arr[]){
				int i,j,k, n = arr.length;
				for(i=0; i<n; i++){
						for(j = k = i; j < n ; j++)
						{
								if(arr[j] < arr[k])
								{
										k = j;
								}
						}
						int temp = arr[k];
						arr[i] = arr[k];
						arr[k] = temp;
				}
		}
}


