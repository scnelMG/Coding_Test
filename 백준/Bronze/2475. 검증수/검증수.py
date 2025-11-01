arr = map(int, input().split())
result = 0
for i in arr:
    result += i * i

result %= 10
print(result)
