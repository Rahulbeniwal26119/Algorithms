import bisect
# approach when array are sorted then each successful search of previous element will tell from where to start search for another element so it will reduct the search space every time
def find_common(l1,l2):
    found = 0 #from where element to search in bin_search
    common = []
    l = len(l1)
    for i in range(l):
        element = l1[i]
        print(found, l-1)
        pos = bin_search(l2,element,found,l-1)
        if pos is not None:
            common.append(element)
            found+=1
    return common

def bin_search(a, x, l, h):
    try:
        if h < l:
            return None
        mid = (l+h)//2
        if a[mid] == x:
            return mid
        elif a[mid] > x:
            return bin_search(a,x,l, mid-1)
        else:
            return bin_search(a,x,mid+1,h)
    except Exception as e:
        return None

print(find_common([17,27,35,40,49,55,59, 60], [17,35,39,40,55,58,60, 61]))

#print(bin_search([1,3,4,5,6,7], 6, 0, 15))
