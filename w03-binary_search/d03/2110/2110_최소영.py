import sys
input = sys.stdin.readline

def wifi():
    n, c = map(int, input().split())
    
    houses = [int(input()) for _ in range(n)]
    houses.sort()
    
    # 최대 거리를 구하는 문제이므로 lt, rt 값을 거리로 설정
    lt = 1
    rt = houses[-1] - houses[0] # 첫번째 집과 마지막 집의 거리 차
    answer = 0
    
    while lt <= rt:
        mid = (lt + rt) // 2 # 인접한 두 공유기 사이의 거리 (최대 거리)
        install = houses[0] # 첫번째 집에는 무조건 공유기 설치
        count = 1
    
        for i in range(1, n): # 두번째 집부터 거리 검사
            if houses[i] - install >= mid: # 최근에 공유기를 설치한 집과의 거리 차이가 mid보다 크거나 같으면
                install = houses[i] # 해당 집에 공유기 1개 설치
                count += 1
                
                if count == c: # 공유기를 모두 설치했다면 그만 검사
                    break
    
        if count == c: # 공유기를 모두 설치할 수 있으면 공유기 사이의 거리를 늘려서 검사
            answer = mid
            lt += 1
        else: # 공유기를 모두 설치할 수 없으면 공유기 사이의 거리를 줄여서 검사
            rt -= 1
        
    print(answer)

wifi()
