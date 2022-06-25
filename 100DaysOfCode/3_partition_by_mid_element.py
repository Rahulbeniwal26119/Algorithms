def partition(arr, i, j, pivot_index):
    if len(arr) == 1: return
    while(j > i):
        while arr[i] <= arr[pivot_index]:
            i+=1
        while arr[j] > arr[pivot_index]:
            j-=1
        if i < j:
            arr[i], arr[j] = arr[j], arr[i]
    swap(arr, j, pivot_index)
    return j

def quicksort(arr, i, j):
    if len(arr) == 1: return
    else:
        pivot = (i+j)//2
        if j > i:
            print(i , j)
            index = partition(arr, i, j, pivot)
            quicksort(arr, i, pivot-1)
            quicksort(arr, pivot+1, j)

def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]

arr = [4,323,324,342,41,34,34,342,342,432]
quicksort(arr, 0, len(arr)-1)
print(arr)
