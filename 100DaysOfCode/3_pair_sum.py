sum = 3 or int(input())
arr = [1,2,3,0,-3, 6, 5, -2] or map(int, input().split(' '))

pair_dict = {}
for i in arr:
    pair_dict.update({i : sum - i })

pairs = []
real_pair_dict = {}
for i in arr:
    other_element = pair_dict.get(i)
    if other_element:
        if not real_pair_dict.get(other_element):
            pairs.append((i, other_element))
            # logic for removing the duplicate element
            real_pair_dict[i] = other_element
print(pairs)
print(real_pair_dict)
