def quicksort(arr, lt, rt):
    if len(arr) == 1:
        return arr
    if lt < rt:
        p_position = partition(arr, lt, rt)
        quicksort(arr, lt, p_position-1)
        quicksort(arr, p_position+1, rt)
    return arr

def partition(arr, lt, rt):
    pivot, ptr = arr[rt], lt
    for i in range(lt, rt):
        if arr[i] <= pivot:
            arr[i], arr[ptr] = arr[ptr], arr[i]
            ptr+=1
    arr[ptr], arr[rt] = arr[rt], arr[ptr]
    return ptr

example = [4,5,1,2,3]
print(quicksort(example, 0 , len(example)-1))

