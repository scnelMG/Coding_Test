T = int(input())


for _ in range(T):
    k = int(input())
    n = int(input())
    temp = [[i for i in range(1, n + 1)]]

    for i in range(1, k + 2):
        temp.append([1] + [0] * (n - 1))
        for j in range(1, n):
            temp[i][j] = temp[i - 1][j] + temp[i][j - 1]

    print(temp[k][n - 1])
