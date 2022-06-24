# Author -> Rahul Beniwal 
def parity(x):
    # it will take O(S) where S is the number of bits in number
    result = 0
    while x:
        result ^= x & 1
        x >>= 1
    return result

# Author -> Rahul Beniwal 
def parity_2(x):
    result = 0
    # till will take O(N) where N is the number of bit with value 1
    while x:
        result ^= 1
        x &= x - 1
    return result


PRECOMPUTED_PARITY = {
    0: 0,
    1: 1,
    2: 1,
    3: 0
}

# Author -> Rahul Beniwal 
def parity_3(x):
    MASK_SIZE = 2
    BIT_MASK = 0x3
    # for 8 bit Masking we need 2 full bytes
    # for 16 bit Masking we need 4 full bytes or 0xF
    # for 64 bit Masking we need 16 full bytes or 0xFFFF
    # MASK_SIZE is the number of full bytes
    # time complexity is O(n/L) is the width of word which cache result where L is 2
    # and n is the word size which is 8 here

    return (
        PRECOMPUTED_PARITY[x >> (3 * MASK_SIZE)]
        ^
        PRECOMPUTED_PARITY[(x >> (2 * MASK_SIZE)) & BIT_MASK]
        ^
        PRECOMPUTED_PARITY[(x >> MASK_SIZE) & BIT_MASK]
        ^
        PRECOMPUTED_PARITY[x & BIT_MASK]
    )


print(parity(int('100110', 2)))
print(parity_2(int('1011000', 2)))
print(parity_3(int('1011000', 2)))
