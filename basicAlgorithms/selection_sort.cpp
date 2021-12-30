#include <iostream>
using namespace std;
void selection_sort(int arr[], int len)
{
    int smallest;
    int j = 0;
    int smallest_index = 0;
    for (int i = 1; i < len; i++)
    {
        smallest = arr[i - 1];
        for (j = i; j < len; j++)
        {
            if (smallest > arr[j])
            {
                smallest = arr[j];
                smallest_index = j;
            }
        }
        int temp;
        temp = arr[i - 1];
        arr[i - 1] = arr[smallest_index];
        arr[smallest_index] = temp;
        for (int i = 0; i < len; i++)
        {
            cout << arr[i] << "\t";
        }
        cout << endl;
    }
}
int main(int argc, char const *argv[])
{
    int a[] = {54, 1, 2, 4, 3, 2, 4};
    selection_sort(a, 7);
}
