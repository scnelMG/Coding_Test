S = input()
for i in range(26):
    alphabet = chr(97 + i)
    if alphabet not in S:
        print(-1, end=" ")
    else:
        print(S.index(alphabet), end=" ")