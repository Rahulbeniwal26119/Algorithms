package sorting;

public class Main{
		public static void main(String []args){
				int array[] = {5,7,9,10,11,12,13,16,24,3};
				// BubbleSort.bubbleSort(array);
				// Insertion is best choice for linked list
				// InsertionSort.insertionSort(array);
				// SelectionSort.selectionSort(array);
				// IterativeMergeSort.iterativeMergeSort(array); 
				// RecursiveMergeSort.recursiveMergeSort(array, 0 , array.length -1);
				// QuickSort.quickSort(array, 0, array.length-1);
				// CountSort.countSort(array);
				   RadixSortLL.radixSortLL(array);
				for(var ele : array)
						System.out.println(ele);
		}
}

