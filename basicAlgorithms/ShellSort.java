public class ShellSort {
    static void shellSort(int arr[])
    {
        for(int gap = arr.length/2; gap > 0 ; gap/=2)
        for(int i = gap; i < arr.length; i++)
        // this loop also check reverse to compare and change the elements
        for(int j = i - gap; j>=0 && arr[j] > arr[j+gap]; j-=gap)
        {
            int temp = arr[j];
            arr[j] = arr[j+gap];
            arr[j+gap] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = {5,4,3,2,1};
        shellSort(arr);
        for(int i : arr)
        System.out.print(i);
    }
}
