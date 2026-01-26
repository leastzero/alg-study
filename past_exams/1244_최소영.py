import sys
input = sys.stdin.readline

n = int(input())
switch = list(map(int, input().split()))
switch.insert(0, 0)

student = int(input())
for _ in range(student):
    gender, number = map(int, input().split())

    if gender == 1: # 남자일 때
        for i in range(number, n+1, number):
            switch[i] ^= 1 # XOR 연산으로 0이랑 1 바꾸기
    else: # 여자일 때
        lt = number - 1
        rt = number + 1
        switch[number] ^= 1 # 내 번호 스위치 상태 바꾸기

        while lt >= 1 and rt <= n and switch[lt] == switch[rt]: # 좌우대칭 확인
            switch[lt] ^= 1
            switch[rt] ^= 1
            lt -= 1
            rt += 1

for i in range(1, n+1):
    print(switch[i], end=' ')

    if i % 20 == 0:
        print()
