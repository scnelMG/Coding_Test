n, m = map(int, input().split())
address = {}

for _ in range(n):
    a, b= input().split()
    address[a] = b

for _ in range(m):
    print(address[input()])