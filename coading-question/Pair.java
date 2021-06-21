import java.util.*;
public class Pair{

		public static void pairedElement(int arr[], int sum){
				int low = 0;
				int high = arr.length - 1;
				while(low < high){
						if(arr[low] + arr[high] == sum)
								System.out.println("(" + arr[low] + "," + arr[high] + ")");
						if(arr[low] + arr[high] > sum)
								--high;
						else 
								++low;
				}
		}

		public static void main(String []args){
				int arr[] = {1,2,34,55,-1,20};
				Arrays.sort(arr);
				pairedElement(arr, 54);
		}
}

