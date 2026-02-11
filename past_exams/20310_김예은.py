# S의 0과 1의 개수는 모두 짝수! (2~500)
# 타노스가 0을 절반, 1을 절반 제거하여 S'를 만든다.
# 그렇다면 S'가 될 수 있는 것 중 가장 빠른 것은?

# 어떻게 풀까
# 1. S의 0과 1을 각각 절반씩 제거해야 하는데... (S'가 될 수 있는 것)
    # 0과 1 각각 전체 개수를 세서 반복하면서 그의 절반 개수만큼 제거하자.
# 2. 그중 제일 빠른 S'는? 
    # 사전 기준이라 했으므로 앞에 0이 몰려 있어야 하고 뒤에 1이 몰려 있어야 함.
    # 1은 앞에서부터 제거하고 0은 뒤에서부터 제거하자.


# 1. 입력값 받아오기
S = input().strip()

# 2. 0과 1 각각 개수 세기 -> sum처럼 뭐.. 느려서 다른 걸 써야 하는 게 있는가?
zero = S.count("0")
one = S.count("1")

# 3-1. new_S를 구할 건데 우선 앞에서 1부터 빼자.
# 어떻게 빼지????????
# 개수를 셌으니까 전체 S를 돌면서 1을 빼자.
# one/2만큼 빼야 하니까 count가 one/2가 되면 나머지는 다 new_S에 append 하자.

new_S = []
one_count = 0

for ch in S:
    if(ch == "1" and one_count < (one / 2)): # 1이거나 one/2만큼 안 돌았을 때
        one_count += 1
    else: # 0이거나 (1인데 절반 넘게 삭제했을 때)
        new_S.append(ch)

# 3-2. 이제 뒤에서 0부터 빼자.
result_S = []
zero_count = 0
for i in range(len(new_S)-1, -1, -1):
    if(new_S[i] == "0" and zero_count < (zero / 2)):
        zero_count += 1
    else:
        result_S.append(new_S[i])

# 4. 출력
result_S.reverse()
print("".join(result_S))
