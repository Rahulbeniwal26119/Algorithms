def swap(array, i, j):
    array[i], array[j] = array[j], array[i]


def quickSort(array, left, right):

    if(left >= right):
        return

    last = left
    pivot = (left + right // 2)
    swap(array, left, pivot)
    i = left+1

    while i <= right:
        if array[i] < array[left]:
            last += 1
            swap(array, i, last)
        i += 1

    swap(array, last, left)
    quickSort(array, left, last-1)
    quickSort(array, last+1, right)


array = [4, 3, 5, 32, 1]
quickSort(array, 0, len(array)-1)
for i in array:
    print(i, end="\t")
