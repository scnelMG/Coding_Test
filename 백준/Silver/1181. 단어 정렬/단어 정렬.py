N = int(input())
lst = []
for _ in range(N):
    s = input()
    if s in lst:
        continue
    else:
        lst.append(s)

lst.sort()
lst.sort(key=len)

for i in lst:
    print(i)
