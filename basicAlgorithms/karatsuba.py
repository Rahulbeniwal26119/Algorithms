def karatsuba(x, y):
    if x < 10 and y < 10:
        return x * y
    else:
        max_len = max(len(str(x)), len(str(y)))
        half = max_len // 2
        a = x // (10**(half))
        b = x % (10**(half))
        c = y // (10**(half))
        d = y % (10**(half))
        ac = karatsuba(a, c)
        bd = karatsuba(b, d)
        ad_and_bc = karatsuba(a + b, c + d) - ac - bd
        return (10**(half * 2)) * ac + (10**(half)) * ad_and_bc + bd


print(karatsuba(54, 4))
print(karatsuba(312, 44))