# 문제 
  # 첫째 줄에 회의의 수 N 
  # 시작 시간 / 끝나는 시간 ...
  # 겹치지 않게 회의실을 사용할 수 있는 최대의 개수는?

import sys
def solution():
    input = sys.stdin.readline
    
    # 1. 입력값 파싱
    # n
    n = int(input().strip())
    
    # meetings = []
    meetings = []
    for _ in range(n):
        s, e = map(int, input().split())
        meetings.append((s, e))
    
    # 2. 정렬 기준
    # 일단 시작하면 끝나는 시간이 빠른 요소로. (끝나는 시간. 오름차순)
    # 끝나는 시간이 같으면? 시작 시간이 빠른 애 (대신 이전 끝나는 시간보다는 느리게)
    meetings.sort(key=lambda x: [x[1], x[0]])
    
    # 3. 그리디
    # 마지막 선택한 회의의 끝나는 시간을 기준으로
    # 다음 회의 시작 시간이 그보다 느리면(이상이면) 선택함.
    possible_count = 0
    last_end_time = 0

    for start, end in meetings:
        # 회의가 끝나는 순간부터 다음 회의 시작 가능..
        if start >= last_end_time:
            possible_count+=1
            last_end_time = end
            
    print(possible_count)
  
solution()
