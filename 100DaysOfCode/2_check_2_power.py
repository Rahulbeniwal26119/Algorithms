def check_2_power(x):
    return True if x & (x - 1) else False

print(check_2_power(8))
print(check_2_power(101))
print(check_2_power(1024))
