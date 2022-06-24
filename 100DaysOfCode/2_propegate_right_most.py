def propegate_right_most(x):
    # convert 01010000 to 01011111
    # this the position of right most bit
    y = x
    shift = 0
    while not (y & 1):
        shift+=1
        y >>= 1
    return ~(-x) | (1 << shift)

print(bin(propegate_right_most(int('01010000', 2))))
