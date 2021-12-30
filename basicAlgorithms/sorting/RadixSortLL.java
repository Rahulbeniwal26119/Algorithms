package sorting;

import java.io.*;
import java.util.*;

public class RadixSortLL {
	static int getMax(int arr[]) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	static int getPasses(int max, int numbers) {
		int count = 0;
		while (max != 0) {
			count++;
			max /= numbers;
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public static void radixSortLL(int arr[]) {
		LinkedList<Integer> outputArray[] = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			outputArray[i] = new LinkedList<Integer>();
		}

		int max = getMax(arr);
		int passes = getPasses(max, 10);
		int exp = 10;
		int divideFactor = 1;
		while (passes > 0) {
			--passes;
			for (var num : arr) {
				var index = (num / divideFactor) % exp;
				outputArray[index].add(num);
			}
			int i = 0;
			for (var list : outputArray) {
				if (!list.isEmpty()) {
					for (int ele : list) {
						arr[i] = ele;
						i++;
					}
				}
			}
			for (var ll : outputArray)
				ll.clear();
			divideFactor *= 10;
		}
	}
}
