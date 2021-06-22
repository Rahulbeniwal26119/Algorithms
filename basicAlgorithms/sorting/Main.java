package sorting;

public class Main {

  public static void main(String[] args) {
    int array[] = { 5, 7, 9, 10, 11, 12, 13, 16, 24, 3 };
	String arr2[] = {"rahul" , "beniwal", "Rah" , "Rahul"};
    // BubbleSort.bubbleSort(array);
    // Insertion is best choice for linked list
    // InsertionSort.insertionSort(array);
    // SelectionSort.selectionSort(array);
    // IterativeMergeSort.iterativeMergeSort(array);
    // RecursiveMergeSort.recursiveMergeSort(array, 0 , array.length -1);
    // QuickSort.quickSort(array, 0, array.length-1);
    // CountSort.countSort(array);
    // RadixSortLL.radixSortLL(array);
    // BucketSort.bucketSort(array);
	  //ShellSort.shellSort(array);
	  BubbleSort2.bubbleSort(arr2);
    for (var ele : arr2) System.out.println(ele);
  }
}
