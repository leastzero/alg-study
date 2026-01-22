# 생각
# 수열의 크기는 1,000(10^3)이라서, 이중 반복문까지는 허용이 된다.(10^6)

# 예시로 생각해보자
# 9
# 1000 2 10 5 20 10 30 20 50
#
# 1. 1000
    # 1-1. 자신보다 앞에 있는 요소가 없으므로 다음으로 이동
# 2. 2
    # 2-1. 자신보다 앞에 있는 유일한 요소인 1000이 자신보다 크다.
        # ...
N = int(input())
A = list(map(int, input().split()))

if N == 1:
    print(1)
    print(A[0])
else:
    dp = [[] for _ in range(N+1)]
    dp[0] = [A[0]]
    
    for i in range(1, N):
        for j in range(i):
            # 이 수를 수열에 넣을 수 있을 때
            if A[i] > A[j]:
                if len(dp[j])+1 > len(dp[i]):
                    dp[i] = dp[j] + [A[i]]
                    
    result = max(dp)
    print(len(result))
    print(" ".join(map(str, result)))
    