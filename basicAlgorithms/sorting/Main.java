package sorting;

public class Main{
		public static void main(String []args){
				int array[] = {1,1,2,3,4,5,6};
				// BubbleSort.bubbleSort(array);
				// Insertion is best choice for linked list
				InsertionSort.insertionSort(array);
				for(var ele : array)
						System.out.println(ele);
		}
}

