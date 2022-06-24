# import copy
# copy.copy make a shallow copy -> Copy the reference of just one level
# copy.deepcopy -> it is recursive and copy the items recursivly

def even_odd(A):
    next_even, next_odd = 0, len(A) - 1
    while next_even < next_odd:
        if A[next_even] % 2 == 0:
            next_even+=1
        else:
            A[next_even], A[next_odd] = A[next_odd], A[next_even]
            next_odd-=1

a = [1,2,3,4,5,6,7,8]
even_odd(a)
print(a)

