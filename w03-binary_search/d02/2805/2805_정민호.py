# 요약
# 상근이가 H를 설정하면
# 각 나무 길이에서 H만큼 잘라내고,
# "나무길이-H"의 나무토막들을 가질 수 있다.
# 상근이는 나무토막들의 길이 총합이 적어도 M미터가 되도록 H를 설정해야 한다.
# -> 조건에 맞는 H의 최댓값을 구하는 문제

# 흐름
# 1. 나무를 오름차순 정렬한다.
# 2. left를 0, right를 가장 큰 나무 길이로 한다.
# 3. mid를 H로 설정한다고 할 때, 리스트의 각 요소에서 H를 뺀 결과를 계산한다.
# 4. 자른 나무 토막 길이의 총합이 
    # 4-1. 목표보다 길거나 같다면 더 높이 잘라보기 위해 left를 mid로 바꾸며, mid를 H로서 메모한다.
    # 4-2. 목표보다 짧다면 더 낮게 잘라야 하므로 right를 mid로 바꾼다.
# 5. 끝까지 진행한 뒤 H를 출력한다.


N, M = map(int, input().split())
trees = list(map(int, input().split()))
trees.sort()

def binary_search():
    left, right = 0, max(trees)

    H = 0
    while (left <= right):
        mid = (left+right) // 2

        total = 0
        for tree in trees:
            total += max(0, tree-mid)

        if M <= total:
            left = mid + 1
            H = mid
        else:
            right = mid - 1

    return H

print(binary_search())
