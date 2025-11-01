s = list(map(int, input().split()))
if s == [i for i in range(1, 9)]:
    print('ascending')
elif s == [i for i in range(8, 0, -1)]:
    print('descending')
else:
    print('mixed')

