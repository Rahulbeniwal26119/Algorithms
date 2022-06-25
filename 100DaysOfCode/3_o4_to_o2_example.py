import time
t1 = time.time()
n = 50

def m1():
    d = {}
    for i in range(n):
        for j in range(n):
            d.update(
                {i**2 + j**2 : (i,j)}
            )

    l = []
    count=0
    for i in range(n):
        for j in range(n):
            val = i**2 + j**2
            if d.get(val):
                print(*d.get(val), i, j)
                count+=1
    print(count)

def m2():
    count = 0
    for i in range(n):
        for j in range(n):
            for k in range(n):
                for l in range(n):
                    if i**2 + j**2 == k**2 + l**2:
                        # print(i,j,k,l)
                        count+=1 
    print(count)
m1()
t2 =time.time()
print(t2 - t1)