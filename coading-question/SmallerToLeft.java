import java.util.*;
public class SmallerToLeft{

	static	public void swap(int arr[], int i, int j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
		}

	static public void  quickSort(int arr[] , int low, int high){
				int left = low + 1;
				int right = high;
				if(left > right)
						return;
				swap(arr, (low+high)/2,low);
				int pivot = low;
				while(right  >= left){
						if(arr[left] > arr[pivot] && arr[right] < arr[pivot])
								swap(arr, left, right);
						else if(arr[left] <= arr[pivot])
								left++;
						else
								right--;
				}
				swap(arr, pivot, right);
				quickSort(arr,low, right - 1);
				quickSort(arr, right + 1, high);
		}

		public static void reverse(int arr[]){
				for(int i = 0; i < arr.length/2; i++){
						int temp = arr[i];
						arr[i] = arr[arr.length - 1 -i];
						arr[arr.length - 1 - i] = temp;
				}
		}

		static int position(ArrayList<Integer> arr, int num){
				int index = 0;
				System.out.println(num);
				while(index < arr.size()  && arr.get(index) < num){
						index++;
				}
				arr.add(index , num);
				return index;
		}

		public static int [] smallerToLeft(int arr[]){
				int length = arr.length;
				ArrayList<Integer> temp = new ArrayList<>();
				int result[] = new int[arr.length];
				reverse(arr);
				int index = 0;
				for(var i : arr){
						int pos = position(temp, i);
						result[index] = pos;
						index++;
				}
				reverse(result);
				return result;

		}
		public static void main(String []args){
				int arr[] = {1,2,3,4,5};
				int result[] = smallerToLeft(arr);
				for(var i : result)
						System.out.print(i + "\t");
		}
}



