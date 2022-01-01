def divide(x,y):
    if x == 0: return (0,0)
    (q,r) = divide(x//2,y)
    q = 2*q
    r = 2*r
    if x%2 != 0:
        r = r+1
    if r >= y:
        r = r-y
        q = q + 1
    return (q,r)

print(divide(101,10))
