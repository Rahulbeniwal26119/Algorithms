#include <iostream>
using namespace std;

void swap(int arr[], int i, int j)
{
    int temp;
    temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
void quick_sort(int arr[], int left, int right)
{
    int right_index = right;
    int left_index = left + 1;
    int pivot = left;
    if (left >= right)
        return;

    while (right_index >= left_index)
    {
        if (arr[right_index] < arr[pivot] && arr[left_index] > arr[pivot])
        {
            swap(arr, left_index, right_index);
        }
        if (arr[left_index] <= arr[pivot])
            left_index++;
        if (arr[right_index] >= arr[pivot])
            right_index--;
    }
    swap(arr, right_index, pivot);
    int check_for_smaller_sub_array = right_index - left > right - right_index;

    if (check_for_smaller_sub_array)
    {
        quick_sort(arr, left, right_index - 1);
        quick_sort(arr, right_index + 1, right);
    }
    else
    {
        quick_sort(arr, right_index + 1, right);
        quick_sort(arr, left, right_index - 1);
    }
}
int main()
{
    int arr[] = {8, 54, 43, 2, 5, 3, 2};
    quick_sort(arr, 0, 6);
    for (int i = 0; i <= 6; i++)
        cout << arr[i] << "\t";
}
