from collections import deque

# 정점의 개수 N
# 간선의 개수 M
# 탐색 시작할 정점 번호 V
def solution(data):
    answer = ''
    # 첫 번째 줄 N, M, V 값 구하기
    lines = data.strip().split('\n')
    N, M, V = map(int, lines[0].split())
    print(N, M, V)

    # 정점 번호 + 1만큼 이웃 리스트 생성 (정점 개수만큼)
    # graph[v] -> v와 연결된 이웃 정점들 리스트 담기
    graph = [[] for _ in range(N+1)] 

    # 나머지 M개의 줄에서 간선이 연결하는 정점의 번호
    for i in range(1, M + 1):
        a, b = map(int, lines[i].split())
        graph[a].append(b) # a에서 b로
        graph[b].append(a) # 양방향 b에서 a로

    # (여러 개면) 작은 번호부터 방문하기 위해 정렬 
    for i in range(1, N+1):
        graph[i].sort()

    print(graph)

    # DFS
    # 방문했는지 여부 리스트 만들기
    visited = [False] * (N + 1)
    dfs_result = []

    # 탐색 시작할 번호를 True로, 방문했으면 추가하고, 방문하지 않았으면 반복
    def dfs(v):
        visited[v] = True
        dfs_result.append(v)
        # v의 이웃들 중 작은 번호부터 순서대로 확인할 거임
        for next in graph[v]:
            if not visited[next]:
                dfs(next)

    dfs(V)

    # BFS
    visited = [False] * (N + 1)
    bfs_result = []

    q = deque([V])
    visited[V] = True

    while q:
        v = q.popleft()
        bfs_result.append(v)
        for next in graph[v]:
            if not visited[next]:
                visited[next] = True
                q.append(next)
    
    print(dfs_result)
    print(bfs_result)

# 테스트 코드
solution(
    """
    4 5 1
    1 2
    1 3
    1 4
    2 4
    3 4
    """
)