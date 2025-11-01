result = 0
max_idx = 0
for i in range(1,10):
    a = int(input())
    if a > result:
        result = a
        max_idx = i
print(result)
print(max_idx)