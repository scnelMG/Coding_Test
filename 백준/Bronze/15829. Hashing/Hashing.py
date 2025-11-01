L = int(input())
S = input()

result = 0
for i, s in enumerate(S):
    s = ord(s) - 96
    result += (31**i) * s
print(result % 1234567891)
