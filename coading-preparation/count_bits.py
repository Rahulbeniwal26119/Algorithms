def count_bits(x):
    num_bits_count = 0
    while x:
        num_bits_count += x & 1
        x = x >> 1;
    return num_bits_count

print(count_bits(10))

