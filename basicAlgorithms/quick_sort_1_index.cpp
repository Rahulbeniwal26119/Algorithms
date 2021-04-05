#include <iostream>
using namespace std;
void swap(int arr[], int i, int j)
{
    int temp;
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void quickSort(int arr[], int left, int right)
{
    int end = left;
    int pivot = (left + right) / 2;
    swap(arr, left, pivot);
    if (left >= right)
        return;
    for (int i = left + 1; i <= right; i++)
    {
        if (arr[i] < arr[left])
            swap(arr, ++end, i);
    }
    swap(arr, left, end);
    for (int i = 0; i < 4; i++)
    {
        cout << arr[i] << "\t";
    }
    cout << endl;
    quickSort(arr, left, end - 1);
    quickSort(arr, end + 1, right);
}
int main()
{
    int a[] = {4, 45, 3, 22};
    quickSort(a, 0, 3);
}