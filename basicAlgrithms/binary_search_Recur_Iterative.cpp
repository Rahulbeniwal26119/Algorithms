#include <iostream>
using namespace std;
int iterative_binary_search(int arr[], int low, int high, int num)
{

    while (low <= high)
    {
        int mid = (low + high) / 2;
        if (arr[mid] == num)
        {
            return mid;
        }
        else if (arr[mid] < num)
        {
            low = mid + 1;
        }
        else
        {
            high = mid - 1;
        }
    }
    return -1;
}
int recursive_binary_search(int arr[], int low, int high, int num)
{
    if (low == high)
    {
        if (arr[low] == num)
            return low;
        else
            return -1;
    }
    else
    {
        int mid = (low + high) / 2;
        if (arr[mid] == num)
        {
            return mid;
        }
        else if (arr[mid] < num)
        {
            return recursive_binary_search(arr, mid + 1, high, num);
        }
        else
            return recursive_binary_search(arr, low, mid - 1, num);
    }
}
// int main(int argc, char const *argv[])
// {
//     int arr[] = {1, 2, 5, 6, 7, 8, 9};
//     // int position = iterative_binary_search(arr, 0, 6, 19);
//     // cout << position;
//     int position = recursive_binary_search(arr, 0, 6, 11);
//     cout << position;
//     return 0;
// }
