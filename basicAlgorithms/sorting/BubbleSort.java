package sorting;

public class BubbleSort{
				
		public static void bubbleSort(int array[]){
				int length = array.length;
				boolean isSorted;
				boolean isAlreadySorted=true;

				for(var i=0; i < length-1; i++)
				{
						isSorted = true;

						for(var j =0; j < length - 1 - i; j++)
						{
								if(array[j] > array[j+1]) 
								{ 
										int temp = array[j];
										array[j] = array[j+1];
										array[j+1] = temp;
										isSorted = false;
										isAlreadySorted = false;
								}
						}
						if(isAlreadySorted)
						{
							System.out.println("Already Sorted");
							break;
						}
						if(isSorted)
						{
							break;
						}
				}
		}
}





