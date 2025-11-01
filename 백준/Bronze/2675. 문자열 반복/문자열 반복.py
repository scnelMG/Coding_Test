T = int(input())
for _ in range(T):
    R, S = input().split()
    for string in S:
        print(string * int(R), end = '')
    print() 