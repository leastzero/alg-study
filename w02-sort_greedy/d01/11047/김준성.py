"""

"""



N, K = map(int, input().split())

coin_values = []

for _ in range(N):
    coin_values.append(input().split())



# 정렬
coin_values.sort(reverse=True)
print(coin_values)

for i in range(len(coin_values)):
    if (coin_values[i] == K):
        pass

    

    
