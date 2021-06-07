package sorting;
import java.io.*;
public class ShellSort{

		static void shellSort(int arr[]){
				int n = arr.length;
				int gap=0;
				for(gap = n/2; gap >= 1; gap/=2){
				for(int i=gap; i<n; i++)
				{
						int temp=arr[i];
						int j = i - gap;

						while(j >= 0 && arr[j] > temp){				
								arr[j+gap] = arr[j];
								j-=gap;
						}
						arr[j+gap] = temp;
				}

				}
		}
}



