public class MergeSort {

    static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = array[low + i];
        for (int j = 0; j < n2; j++)
            right[j] = array[mid + j + 1];
        int i = 0, j = 0, k = low;
        for (; i < n1 && j < n2; k++) {
            if (left[i] <= right[j]) {
                array[k] = left[i++];
            } else
                array[k] = right[j++];
        }

        while (i < n1)
            array[k++] = left[i++];
        while (j < n2)
            array[k++] = right[j++];

    }
    public static void main(String[] args) {
        int array[] = {4,3,2,5,1};
        mergeSort(array , 0 , array.length - 1);
        for(int i : array)
            System.out.println(i);
    }
}
