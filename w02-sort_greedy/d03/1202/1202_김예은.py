## 상덕이 참 나쁘다... 보석을 훔치다니
# 첫째 줄 N (개의 보석) / K (개의 가방)
# 둘째 줄 ~ N+1 -> 보석의 정보 M (무게) / V (가격)
# N+1 ~ 마지막 -> C (가방에 담을 수 있는 최대 무게)
# 가방에는 최대 한 개의 보석만
# 상덕이가 훔칠 수 있는 보석 가격의 합을 최대로 만들어라.

## 어떻게 풀까...
# 정렬
# (1) 보석 가격순으로? 가격순으로 정렬하고 
            # 그 순서대로 가방에 접근하여 들어가는 애를 넣는다.
            # 그럼 문제가 없을까???
# (2) 가방은 정렬하지 않아도 되나? 무게 오름차순으로... 굳이인가..
            # 어쨌든 가방에 담긴 애 중에 가장 비싼 애를 찾는다.
            # 그러면 일단 가방에 담겨야 한다..

## 시도 방법
# 중첩 반복문 쓰기 싫은데.. 어쩔 수 없는 듯.
# 가방에 담길 수 있는지 체크하고 가능한 애들을 배열에 넣어준다.
# 그리고 담긴 애들 중에서 제일 비싼 애들을 선택하면 될 듯.


import sys
def solution():
    input = sys.stdin.readline

    ## 1. 입력값 파싱
    # 보석의 개수 n / 가방의 개수 k
    n, k = map(int, input().split())

    # 보석 정보 배열 (튜플로 한쌍)
    jewels = []
    for _ in range(n):
        m, v = map(int, input().split())
        jewels.append((m, v))
        
    # 가방 정보 배열
    bags = []
    for _ in range(k):
        bags.append(int(input()))

    ## 2. 정렬
    # 보석
    jewels.sort(key=lambda x: x[1]) # 두 번째 값이 가격
    jewels.reverse()

    # 가방
    bags.sort()
    
    ## 3. 그리디
    jewelsinbags = []
    for bag in bags:
        possible_jewels = []
        # 가방 무게랑 보석 무게랑 비교해서 가능한 애들 담아.
        for j in range(len(jewels)):
            if(bag >= jewels[j][0]):
                possible_jewels.append(jewels[j])

            # 가방 하나당 보석 제일 비싼 애 선택
            possible_jewels.sort(key=lambda x: x[1])
            possible_jewels.reverse()
            
        jewelsinbags.append(possible_jewels[0][1])

        # 선택했으면 그 보석은 빼. 없으면 넘어가고.
        if not possible_jewels:
            continue
            
        jewels.remove(possible_jewels[0])
    
    # 그 합을 구해라
    sum = 0
    for value in jewelsinbags:
        sum += value

    return sum

print(solution())
