# 문제
# D킬로미터의 고속도로가 있는데, 지름길을 활용해서 최소한의 거리를 운전해라.

# 주어지는 값
# 첫 번째 - 지름길의 개수 N / 고속도로의 길이 D
# 두 번째 ~ (지름길의 시작 위치, 도착 위치, 지름길의 길이)

# 첫 번째 예제
#  0 ~ 50 10 / 50 ~ 100 10 / 100 ~ 151 10 
    # -> 역주행은 안 되어서 151은 안 되는 듯하다.
# 0 ~ 50 10 / 50 ~ 100 10 / 100 ~ 150 50
    # 10 + 10 + 50 = 70


# 어떻게 풀까
# 어렵구만!! 일단 좀 깔짝이다가 다시 생각해보자.
# shortcuts에 무엇을 넣을까. (도착지, 길이)
# 


import sys
import heapq

# 1. 입력값 파싱
input = sys.stdin.readline
shortcut_num, highway_len = map(int, input().split())

shortcuts = [[] for _ in range(highway_len + 1)]
for _ in range(shortcut_num):
    start, end, sc_len = map(int, input().split()) 
    if end <= highway_len: # 고속도로 길이보다 짧은 지름길만 처리할 거임!
        shortcuts[start].append((end, sc_len)) 

# 배열에 무한대 값 설정
INF = 1e8

distance = [INF] * (highway_len + 1)
distance[0] = 0

# 다익스트라
pq = []
heapq.heappush(pq, (0, 0))

while pq:
    sc_len, x = heapq.heappop(pq)
    print(sc_len, x)
