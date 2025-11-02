while True:
    n = input()
    if n == "0":
        break

    flag = "yes"
    for i in range(len(n)):
        if n[i] == n[-(i + 1)]:
            pass
        else:
            flag = "no"
    print(flag)
