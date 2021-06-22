package sorting;
 class BubbleSort2{

		static void bubbleSort(String arr[]){
				int length=arr.length;
				for(int j=0; j < arr.length; j++)
				{
						for(int k=0; k < arr.length - 1 -j; k++)
								if(arr[k].compareTo(arr[k+1]) > 0){
										String t = arr[k];
										arr[k] = arr[k+1];
										arr[k+1] = t;
								}
				}
		}

}




