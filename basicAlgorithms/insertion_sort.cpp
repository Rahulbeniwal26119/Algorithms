#include <iostream>
using namespace std;
void insertion_sort(int arr[], int len)
{
    int is_sorted = 0;
    int array_length = 1;
    for (; array_length <= len; array_length++)
    {
        if (array_length == 1)
            ;
        else
        {
            for (int j = array_length; j > 1; j--)
            {
                if (arr[j - 1] < arr[j - 2])
                {
                    int temp;
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j - 2];
                    arr[j - 2] = temp;
                }
            }
        }
        for (int i = 0; i <= len - 1; i++)
        {
            cout << arr[i] << "\t";
        }
        cout << endl;
    }
}
int main(int argc, char **argv)
{
    int arr[] = {3, 4, 2, 1, 2};
    insertion_sort(arr, 5);
    // for(int i=0; i<5; i++)
    // cout << arr[i] << "\t";
}