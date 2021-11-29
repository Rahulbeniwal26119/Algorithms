# parity of a word is one if
# number of 1s in one  is odd
# otherwise it is 0
def count_parity(x):
    parity_count = 0
    while x:
        parity_count ^= x & 1
        x >>= 1
    return parity_count

print(count_parity(10))
