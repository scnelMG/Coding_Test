N = int(input())
fac = 1
for i in range(1, N + 1):
    fac *= i

result = 0
while fac >= 0:
    if fac % 10 != 0:
        break
    else:
        result += 1
    fac = fac // 10

print(result)
