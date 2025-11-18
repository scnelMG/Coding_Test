import sys

T = int(sys.stdin.readline())
for _ in range(T):
    s = sys.stdin.readline().rstrip()
    lst = []
    flag = 0
    for i in s:
        if i == ")":
            if "(" not in lst:
                flag = 1
                break
            else:
                lst.pop()
        else:
            lst.append(i)
    if len(lst) != 0:
        flag = 1
    if flag == 1:
        print("NO")
    else:
        print("YES")
