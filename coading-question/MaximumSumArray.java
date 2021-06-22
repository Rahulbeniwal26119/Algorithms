public class MaximumSumArray{

		static int sum(int arr[] , int i, int j){
				int summation = 0;
				for(int k = i; k <=j ; k++)
						summation+=arr[k];
				return summation;
		}

		// correct but takes O(n^3) time  
		static public int maximumSum(int arr[]){
				int currentMax = 0;
				for(int i=0; i<arr.length; i++)
						for(int j=i; j < arr.length; j++)
						{
								int sum = sum(arr, i , j);
								if(sum > currentMax)
										currentMax = sum;
						}
				return currentMax;
		}

		// modified to work on both +ve and -ve numbers
		static int kadaneAlgorithm(int a[]){
				int maxSoFar = Integer.MIN_VALUE;
				int maxEndingHere = 0;

				for(int i=0; i<a.length; i++){
						maxEndingHere += a[i];
						if(maxEndingHere < a[i])
								maxEndingHere = a[i];
						if(maxEndingHere > maxSoFar)
								maxSoFar = maxEndingHere;
				}
				return maxSoFar;
		}

		public static void main(String []args){
				int arr[] = {34,-50,42,14,-5,86};
				int summation = kadaneAlgorithm(arr);
				System.out.println(summation);
		}
}

