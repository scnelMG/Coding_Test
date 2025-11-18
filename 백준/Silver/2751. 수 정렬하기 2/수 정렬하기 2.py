import sys
N = int(sys.stdin.readline())

lst = []
for _ in range(N):
    n = int(sys.stdin.readline())
    lst.append(n)

lst.sort()
for i in lst:
    print(i)
