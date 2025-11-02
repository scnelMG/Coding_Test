ISBN = input().strip()
idx = ISBN.index("*")
total = 0
weight = [1 if i % 2 == 0 else 3 for i in range(12)]
for i in range(12):
    if i == idx:
        continue
    total += int(ISBN[i]) * weight[i]

for j in range(10):
    tmp = j * weight[idx] + total
    m = int(ISBN[-1])
    if (tmp + m) % 10 == 0:
        print(j)
        break
