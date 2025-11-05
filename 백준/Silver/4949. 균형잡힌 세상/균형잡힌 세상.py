while True:
    temp = []
    result = "yes"
    S = input()
    if S == ".":
        break
    else:
        for s in S:
            if s == "(" or s == "[":
                temp.append(s)
            elif s == ")":
                if "(" not in temp:
                    result = "no"
                    break
                elif "(" != temp[-1]:
                    result = "no"
                    break
                else:
                    temp.pop()
            elif s == "]":
                if "[" not in temp:
                    result = "no"
                    break
                elif "[" != temp[-1]:
                    result = "no"
                    break
                else:
                    temp.pop()
        if len(temp) != 0:
            result = "no"

    print(result)
