import sys
input = sys.stdin.readline

n,m = map(int, input().split())
trees = list(map(int, input().split()))

def cutTree():
    start = 0
    end = max(trees)
    mid = 0
    while start <= end:
        result = 0
        mid = (start + end)//2
        for tree in trees:
            # print(tree, mid)
            result += (tree-mid) if tree > mid else 0
        # print(result)
        if result < m:
            end = mid - 1
        elif result == m:
            return mid
        elif result > m:
            start = mid + 1
        # print(result, start, end)
    
    while result < m:
        result = 0
        mid -= 1
        for tree in trees:
            # print(tree, mid)
            result += (tree-mid) if tree > mid else 0

    return mid
print(cutTree())
