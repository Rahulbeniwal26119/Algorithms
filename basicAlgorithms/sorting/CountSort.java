package sorting;
public class CountSort{

		static int max(int []list, int position, int largest){
			if(position == 0)
					return largest;

			if(position > 0){
					if(list[position] > largest)
							largest = list[position];
			}
				return 	max(list, position-1, largest);
		}

		public static void countSort(int A[]){
				int length = A.length;
				int max = max(A, A.length-1, A[0]);

				int countArray[] = new int[max+1];
				for(int i=0; i < length; i++){
						countArray[A[i]]++;
				}
				
				int origionalIndex = 0;
				for(int i=0; i<=max; i++)
				{
						while(countArray[i] > 0){
								A[origionalIndex++] = i;
								countArray[i]--;
						}
				}

		}
}
		
