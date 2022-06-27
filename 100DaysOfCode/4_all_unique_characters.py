string = input()
def check_dup_1(string):
    char_array = [0] * 128
    if not len(string):
        print("Length of string should be greater than 0")
    breaks = False

    for c in string:
        int_repr = ord(c)
        char_array[int_repr] += 1
        if char_array[int_repr] > 1:
            breaks = True
            break

    if breaks:
        print(f"{string} contains duplicates")
    else:
        print(f"{string} has unique characters.")

def check_dup_2(string):
    checker = 0 << 128
    for c in string:
        if checker & ( 1 << ord(c)):
            return False
        checker |= 1 << ord(c)
    return True

print(check_dup_2(string))


