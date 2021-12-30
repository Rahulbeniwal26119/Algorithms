import java.util.Arrays;
public class SmallestWindow{

		// easy but takes O(nlogn) and O(n) space 
		public static int [] smallestWindow(int arr[]){
				int length = arr.length;
				int temp[] = new int[arr.length];
				for(int j = 0; j < arr.length; j++)
						temp[j] = arr[j];
				Arrays.sort(arr);
				int left=-1, right=-1;
				for(int i=0; i<length; i++){
						if(arr[i] != temp[i] && left == -1)
								left = i;
						else if(arr[i] != temp[i])
								right = i;
				}
				return new int[]{left,right};
		}

		static void printResult(int arr1[]){
				System.out.println("(" + arr1[0] + "," + arr1[1] + ")");
		}

		// take O(n) time and O(1) space 
		static int[] smallestWindow2(int arr[]){
				int length = arr.length;
				int left=-1, right=-1;
				int min_seen = Integer.MAX_VALUE;
				int max_seen = Integer.MIN_VALUE;
				for(int i=0; i<arr.length; i++){

						if(arr[i] < max_seen){
								right = i;
						}

						if(arr[i] > max_seen)
						{
								max_seen = arr[i];
						}
				
				for(int i = length - 1; i >=0; i--){
						if(arr[i] < min_seen)
								min_seen = arr[i];
						if(arr[i] > min_seen)
								left = i;
				}
				return new int[]{left, right};
		}

						



		public static void main(String []args){
				int arr[] = {5,4,3,2,1};
				int arr2[] = smallestWindow2(arr);
				printResult(arr2);
		}
}

