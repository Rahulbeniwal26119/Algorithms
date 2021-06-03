package sorting;
public class InsertionSort{

		protected static void insertionSort(int arr[]){
				int length = arr.length;
				for(var i=1; i < length; i++){
						int j = i - 1;
						while(j > - 1 && arr[i] < arr[j])
						{
								arr[j+1] = arr[j];
								j--;
						}
						arr[j+1] = arr[i];
				}
		}
}


