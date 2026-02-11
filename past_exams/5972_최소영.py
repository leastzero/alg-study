import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
dist = [INF] * (n+1)

for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))
    graph[b].append((a, c))

hq = []
heapq.heappush(hq, (0, 1))
dist[1] = 0

while hq:
    cur_dist, cur = heapq.heappop(hq)

    if cur_dist > dist[cur]:
        continue

    for next, weight in graph[cur]:
        cost = cur_dist + weight
        
        if cost < dist[next]:
            dist[next] = cost
            heapq.heappush(hq, (cost, next))

print(dist[n])
