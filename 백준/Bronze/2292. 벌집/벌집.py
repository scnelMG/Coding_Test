N = int(input())
cnt = 1
N = N - 1
while N > 0:
    cnt += 1
    N -= 6 * (cnt - 1)

print(cnt)
