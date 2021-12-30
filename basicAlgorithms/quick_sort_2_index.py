def swap(array, i, j):
    array[i], array[j] = array[j], array[i]


def quickSort(array, left, right):
    if left >= right:
        return
    pivot = left
    leftIndex = left + 1
    rightIndex = right
    while rightIndex >= leftIndex:
        if array[leftIndex] > array[pivot] and array[rightIndex] < array[pivot]:
            swap(array, leftIndex, rightIndex)
        if array[leftIndex] <= array[pivot]:
            leftIndex += 1
        if array[rightIndex] >= array[pivot]:
            rightIndex -= 1
    swap(array, rightIndex, pivot)

    smallerSubArray = rightIndex - left >= right - rightIndex
    if smallerSubArray:
        quickSort(array, left, rightIndex - 1)
        quickSort(array, rightIndex+1, right)
    else:
        quickSort(array, rightIndex+1, right)
        quickSort(array, left, rightIndex - 1)


array = [8, 5, 2, 9, 5, 6, 3]
quickSort(array, 0, len(array) - 1)
for i in array:
    print(i, end="\t")
