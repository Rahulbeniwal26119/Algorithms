public class insertion_sort {
    static void insertionSort(int  [] array)
    {
        int j=1;
        for(j=1; j<array.length; j++)
        {
            for(int i = j; i > 0; i--)
            {
                if(array[i] <  array[i-1])
                {
                    int temp = array[i];
                    array[i] = array[i-1];
                    array[i-1] = temp; 
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr [] = { 5 ,4 , 3,2,1};
        insertionSort(arr);
        for(int i : arr)
        System.out.print(i);
    }
}
