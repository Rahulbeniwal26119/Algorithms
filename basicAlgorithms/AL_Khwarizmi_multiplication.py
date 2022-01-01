def multiplication(x,y):
    if y == 0:
        return 0
    z = multiplication(x, y//2)
    if y % 2 != 0:
        return  x + 2 * z 
    return 2 * z

print(multiplication(100, 45)) 

