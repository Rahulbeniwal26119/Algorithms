package sorting;

public class Main{
		public static void main(String []args){
				int array[] = {10,5,4,1,2,2,3,4,5};
				// BubbleSort.bubbleSort(array);
				// Insertion is best choice for linked list
				// InsertionSort.insertionSort(array);
				// SelectionSort.selectionSort(array);
				QuickSort.quickSort(array, 0, array.length-1);
				for(var ele : array)
						System.out.println(ele);
		}
}

