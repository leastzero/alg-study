def solution(n):
    # 피보나치 초기값 (1. 반복문)
    a, b = 0, 1

    # # DP (3. DP)
    # memo = [0] * (n+1)

    # n이 0인 경우
    if n == 0:
        return 0

    # 1. 반복문
    else:
        for _ in range(1, n):
            a, b = b, a + b
        return b
        
    # # 2. 재귀 함수 -> 시간 초과
    # elif n == 1:
    #     return 1
    # else: 
    #     return solution(n-1) + solution(n-2)

    # # 3. DP -> 시간 초과
    # elif n == 1:
    #     return 1
    # if memo[n] != 0:
    #     return memo[n]
    # memo[n] = solution(n-1) + solution(n-2)
    # return memo[n]


# 입력값 파싱
n = int(input())
print(solution(n))
