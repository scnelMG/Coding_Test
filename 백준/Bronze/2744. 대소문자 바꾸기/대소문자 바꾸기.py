a = input()
for s in a:
    if s.isupper() == True:
        print(s.lower(), end="")
    else:
        print(s.upper(), end="")
