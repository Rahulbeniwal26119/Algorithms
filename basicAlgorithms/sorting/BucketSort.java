package sorting;
import java.util.LinkedList;
import java.util.Iterator;


public class BucketSort {
    static int findMax(int arr[]){
        int max = arr[0];
        for(var i : arr)
        {
            if(i > max)
                max = i;
        }
        return max;
    }    

    @SuppressWarnings("unchecked")
    static void bucketSort(int arr[]){
        int max = findMax(arr);
        LinkedList<Integer> outputList[] = new LinkedList[max+1];
        for(int i=0; i<=max; i++)
            outputList[i] = new LinkedList<>();
        for(var i : arr){
            outputList[i].add(i);
        }
        int index = 0;
        for(var i : outputList){
            Iterator it = i.iterator();
            while(it.hasNext()){
                arr[index] = (int)it.next(); 
                ++index;
            }
        }
    }
}
