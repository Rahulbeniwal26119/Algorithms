#include <iostream>
using namespace std;
int main(int argc, char **argv)
{
    int arr[] = {5, 4, 3, 2, 1};
    for (int i = 0; i <= 4; i++)
    {
        for (int j = 0; j <= 4 - i; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                int temp;
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        for (int i = 0; i <= 4; i++)
        {
            cout << arr[i] << "\t";
        }
        cout << endl;
    }
}