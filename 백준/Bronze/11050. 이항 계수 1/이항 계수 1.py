N, K = map(int, input().split())

up = 1
down = 1
for i in range(K):
    up *= N - i
    down *= i + 1
result = int(up / down)
print(result)
