from functools import reduce

# with reduce
def remaing_product(lst):
    return [
        reduce(lambda x,y : x * y, lst[i+1:] + lst[:i:]) for i in range(len(lst))
    ]

# without reduce and without division
print(remaing_product([1,2,3,4,5]))
