# N = int(input())
# arr = [i for i in range(1, N + 1)]

# while True:
#     if len(arr) == 1:
#         print(arr[0])
#         break
#     arr = arr[1:]
#     if len(arr) == 1:
#         print(arr[0])
#         break
#     temp = arr[0]
#     arr.append(temp)
#     arr = arr[1:]

from collections import deque

N = int(input())
queue = deque([i for i in range(1, N + 1)])

while len(queue) > 1:
    queue.popleft()
    queue.append(queue.popleft())

print(queue[0])