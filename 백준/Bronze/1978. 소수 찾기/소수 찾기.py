N = int(input())

arr = list(map(int, input().split()))
cnt = 0
for num in arr:
    for i in range(2, num + 1):
        if i == num:
            cnt += 1
        if num % i == 0:
            break

print(cnt)
