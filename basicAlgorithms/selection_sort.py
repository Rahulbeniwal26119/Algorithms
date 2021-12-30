def selectionSort(array):
    smallest_index = 0
    for i in range(1, len(array)):
        j = i
        smallest = array[i-1]
        smallest_index = i-1
        while(j < len(array)):
            if(smallest > array[j]):
                smallest = array[j]
                smallest_index = j
            j += 1
        array[i-1], array[smallest_index] = array[smallest_index], array[i-1]
        print(smallest_index)
        for i in array:
            print(i, end="\t")
        print()

    return array


arr = [54, 1, 2, 4, 3, 2, 4]
selectionSort(arr)
for i in arr:
    print(i, end=" ")
