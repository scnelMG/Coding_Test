N, M = map(int, input().split())
matrix_1 = []
for i in range(N):
    matrix_1.append(list(map(int, input().split())))

for i in range(N):
    temp = list(map(int, input().split()))
    for j in range(M):
        print(temp[j] + matrix_1[i][j], end=" ")
    print()
