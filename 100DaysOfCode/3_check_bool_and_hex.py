def get_char_value_map( base):
    if base == 2:
        return {
            "0" : 0,
            "1" : 1
        }
    elif base == 16:
        char_value_map = {}
        decimals = "0123456789"
        alphas = "abcdef"
        char_0_value = ord("0")
        char_a_value = ord("a")
        for c in decimals:
            char_value_map.update({c : ord(c) - char_0_value})
        for c in alphas:
            char_value_map.update({c : ord(c) - char_a_value + 10})
        return char_value_map
    else:
        return {}

def get_value(string,base):
    char_value_map = get_char_value_map(base)
    value=0
    number_length = len(string)
    for index, c in dict(enumerate(string)).items():
        digit = char_value_map[c]
        if digit < 0 or digit > base:
            return -1
        exp = number_length -1 - index
        value += digit * base**exp

    return value

value1 = "11111111"
value2 = "ff"
print(get_value(value1, 2))
print(get_value(value2, 16))


