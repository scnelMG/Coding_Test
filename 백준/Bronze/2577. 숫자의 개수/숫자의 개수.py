A = int(input())
B = int(input())
C = int(input())
for i in range(10):
    cnt = 0
    for s in str(A * B * C):
        if int(s) == i:
            cnt += 1
    print(cnt)
