# 양방향 간선
# 번호는 1번부터 시작
# 1번 컴퓨터와 직/간접적으로 연결된 컴퓨터 수를 출력하면 됨.

# 1. N 초기화
# 2. M 초기화
# 3. defaultdict 초기화
# 4. bfs를 통해 1번에서부터 정점 방문하는 수 count
# 5. 정점 방문 수 출력

from collections import deque, defaultdict

# 1
N = int(input())

# 2
M = int(input())

# 3
dd = defaultdict(list)
for _ in range(M):
    s, e = map(int, input().split())
    dd[s].append(e)
    dd[e].append(s)

# 4.
def bfs(start):
    result = 0
    visited = [False for _ in range(N+1)]
    visited[start] = True
    q = deque([start])

    while q:
        v = q.popleft()
        for n in dd[v]:
            if not visited[n]:
                visited[n] = True
                result += 1
                q.append(n)
    return result
        
# 5
print(bfs(1))
