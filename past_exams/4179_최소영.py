import sys
from collections import deque

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

r, c = map(int, input().split())
board = [list(input()) for _ in range(r)]
answer = 0

# 지나간 자리 방문 체크
visited_jihoon = [[-1] * c for _ in range(r)]
visited_fire = [[-1] * c for _ in range(r)]

jihoon_Q = deque()
fire_Q = deque()

for i in range(r):
    for j in range(c):
        # 지훈이 시작 위치
        if board[i][j] == 'J':
            visited_jihoon[i][j] = 0
            jihoon_Q.append((i, j))
        # 불 위치
        if board[i][j] == 'F':
            visited_fire[i][j] = 0
            fire_Q.append((i, j))

# 불 확산
while fire_Q:
    x, y = fire_Q.popleft()

    for i in range(4):
        xx = x + dx[i]
        yy = y + dy[i]

        if 0 <= xx < r and 0 <= yy < c and board[xx][yy] != '#' and visited_fire[xx][yy] == -1:
            visited_fire[xx][yy] = visited_fire[x][y] + 1
            fire_Q.append((xx, yy))

# 지훈이 이동
while jihoon_Q:
    x, y = jihoon_Q.popleft()

    # 위치가 미로의 가장자리라면 탈출
    if x == r - 1 or y == c - 1:
        answer = visited_jihoon[x][y] + 1
        break

    for i in range(4):
        xx = x + dx[i]
        yy = y + dy[i]

        if 0 <= xx < r and 0 <= yy < c and board[xx][yy] == '.' and visited_fire[xx][yy] == -1 and visited_jihoon[xx][yy] == -1:
            visited_jihoon[xx][yy] = visited_jihoon[x][y] + 1
            jihoon_Q.append((xx, yy))

if answer == 0:
    print("IMPOSSIBLE")
else:
    print(answer)
