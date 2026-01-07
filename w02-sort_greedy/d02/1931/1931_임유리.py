# 회의실 배정
# N개의 회의실 사용표
# I에 대해 시작시간, 끝나는 시간,
# 겹치지않는 최대개수
# 회의 중단X, 끝 동시에 시작 가능

# 시간이 짧은 회의부터 넣어보자
# 일단 회의실을 최대한 적게 초기화
# 원래는 배열로 쓰는시간을 1, 안쓰는 시간을 0으로 하려고 했는데 시간 범위가 너무 커서 안될듯


import sys

input = sys.stdin.readline

N = int(input())
meets = [[0] * (N + 1) for _ in range(N + 1)]
# 한 회의실에 최대 N개의 회의 들어가기 가능
rooms = [0] * (N)
for i in range(1, N + 1):
    a, b = map(int, input().split())
    # 시작시간 index는 1, 끝나는 시간 index는 2
    meets[i] = [b - a, a, b]
meets.sort()

empty = True
# 일단 첫번째 회의실부터 채워보고 안되면 다음 회의실에 넣기
for meet in meets:
    # 회의실 마지막 회의의 b가 현재 넣으려는 회의의 a보다 작아야만 append 가능
    # 대신 첫 회의는 무조건 넣고 continue
    if empty:
        empty = False
        rooms[0] = meet
        continue
    for i in range(N - 1):
        # 회의끝시간이 내 회의 시작시간보다 늦으면 continue
        if rooms[i] != 0 and rooms[i][2] > meet[1]:
            continue
        # 다음 타임에 회의실 등록안돼있으면 무조건 넣고 다음 회의 검사(break)
        if rooms[i + 1] == 0:
            rooms[i + 1] = meet
            break
        # 다음 회의 시작시간이 내 회의 시작시간보다 빠르면 continue
        if rooms[i + 1][1] < meet[2]:
            continue
for room in rooms:
    print(room)
