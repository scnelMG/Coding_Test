T = int(input())
for _ in range(T):
    H, W, N = map(int, input().split())
    floor = N % H
    num = N // H + 1
    if floor == 0:
        floor = H
        num -= 1
    print(floor * 100 + num)
