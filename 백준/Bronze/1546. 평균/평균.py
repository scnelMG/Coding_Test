N = int(input())

scores = list(map(int, input().split()))
max_v = max(scores)
for i in range(N):
    scores[i] = scores[i] / max_v * 100
result = sum(scores) / N
print(result)
