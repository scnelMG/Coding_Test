n = int(input())
for _ in range(n):
    s = input()
    plus = 1
    score = 0
    for string in s:
        if string == 'O':
            score += plus
            plus += 1
        else:
            plus = 1
    print(score)
