from collections import deque
import sys

input = sys.stdin.readline

dx = [1, 2, 2, 1, -1, -2, -1, -2]
dy = [2, 1, -1, -2, -2, -1, 2, 1]

t = int(input())

for _ in range(t):
    n = int(input())
    sx, sy = map(int, input().split())
    ex, ey = map(int, input().split())

    if sx == ex and ex == ey:
        print(0)
        continue

    visited = [[False] * n for _ in range(n)]

    Q = deque([(sx, sy, 0)])
    visited[sx][sy] = True

    while Q:
        x, y, distance = Q.popleft()

        for i in range(8):
            xx = x + dx[i]
            yy = y + dy[i]
            if 0 <= xx < n and 0 <= yy < n and not visited[xx][yy]:
                if xx == ex and yy == ey:
                    print(distance + 1)
                    Q.clear()
                    break

                visited[xx][yy] = True 
                Q.append((xx, yy, distance + 1))