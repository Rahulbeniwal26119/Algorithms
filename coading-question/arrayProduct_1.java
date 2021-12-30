// in this problem we have to calculate the product of all array element for a position 
// excepting the number at position without division 

import java.util.*;
class ArrayProduct{

		static int [] reverseArray(int [] arr){
				int result []= new int[arr.length];
				for(int i=0; i < arr.length; i++)
						result[i] = arr[arr.length -1 -i];
				return result;
		}


		static int [] product(int arr[]){
				int arr1[] = new int[arr.length];
				int arr2[] = new int[arr.length];

				for(int i=0; i < arr.length; i++)
						arr1[i] = arr2[i] = 1;
				for(int i=0; i < arr.length; i++)
				{
						if(i == 0)
								arr1[i] = arr[i];
						else {
								arr1[i] = arr1[i-1]*arr[i];
						}
				}
				int reversedArray [] = reverseArray(arr);
				for(int i=0; i < arr.length; i++)
						if(i == 0)
								arr2[i] = reversedArray[i];
						else{
								arr2[i] = arr2[i-1] * reversedArray[i];
						}
				reversedArray = reverseArray(arr2);
				for(int i = 0; i < arr.length; i++)
				{
						if(i==0)
								arr[i] = reversedArray[i+1];
						else  if(i == arr.length -1)
								arr[i] = arr1[i -1];
						else
								arr[i] = arr1[i-1] * reversedArray[i+1];
				}
				return arr;
		}

		public static void main(String []args){
				int arr[] = {1,2,3,4,5};
				int result[] = product(arr);
				for(var i : result)
						System.out.print(i + "\t");
		}
}

