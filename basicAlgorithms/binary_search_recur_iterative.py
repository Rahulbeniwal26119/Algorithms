def iterative_binary_search(arr, low, high, num):
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == num:
            return mid
        elif arr[mid] < num:
            low = mid + 1
        else:
            high = mid - 1
    return -1


def recursive_binary_search(arr, low, high, num):
    if low == high:
        if arr[low] == num:
            return low
        else:
            return -1
    else:
        mid = (low + high) // 2
        if arr[mid] == num:
            return mid
        elif arr[mid] < num:
            return recursive_binary_search(arr, mid + 1, high, num)
        else:
            return recursive_binary_search(arr, low, mid - 1, num)

