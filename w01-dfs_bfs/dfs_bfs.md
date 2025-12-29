# **1. DFS와 BFS란?**

> 그래프(또는 트리)에서 **모든 정점(노드)을 방문하기 위한 탐색 방법.**
- **“어떤 순서로 방문하느냐”** 의 차이가 있다.

### **DFS (Depth-First Search)**

- 한 방향으로 **끝까지 내려간 후** 되돌아오며 탐색

### **BFS (Breadth-First Search)**

- 현재 위치에서 **가까운 것부터 차례로** 탐색

---

# **2. 왜 DFS와 BFS로 나뉘는가?**

> 탐색 순서에 따라 **문제를 푸는 난이도와 가능 여부가 갈리기 때문.**

| **기준** | **DFS** | **BFS** |
| --- | --- | --- |
| 탐색 방식 | 깊이 우선 | 거리 우선 |
| 구현 | 재귀 / 스택 | 큐 |
| 최단거리 보장 | ❌ | ⭕ (가중치 없을 때) |
| 메모리 | 상대적으로 적음 | 상대적으로 큼 |
| 활용 | 완전탐색, 경우의 수 | 최단거리, 단계별 확산 |

---

# **3. 언제 DFS를 쓰는가**

- 다음 키워드가 보이면 **DFS부터 의심**하자.
    - 모든 경우를 탐색
    - 경로 존재 여부
    - 백트래킹
    - 조합 / 순열
    - 트리 순회

### **DFS 핵심 포인트**

- **끝까지 가본다.**
- 중간에 조건 안 맞으면 되돌아온다.
- “선택 → 재귀 → 되돌리기” 패턴

---

# **4. 언제 BFS를 쓰는가**

- 다음 키워드가 보이면 **BFS가 거의 정답**이다.
    - 최단거리
    - 최소 횟수
    - 몇 번 만에 도착
    - 동시에 퍼짐
    - 레벨 단위 탐색

### **BFS 핵심 포인트**

- **큐 사용**
- 먼저 들어간 것이 먼저 나온다.
- 처음 도달한 순간이 최단거리.

---

# **5. DFS 구현 (Python 예시)**

### **재귀 방식**

```python
def dfs(v):
    visited[v] = True
    for nxt in graph[v]:
        if not visited[nxt]:
            dfs(nxt)
```

### **스택 방식**

```python
stack = [start]
while stack:
    v = stack.pop()
    if visited[v]:
        continue
    visited[v] = True
    for nxt in graph[v]:
        if not visited[nxt]:
            stack.append(nxt)
```

---

# **6. BFS 구현 (Python 예시)**

```python
from collections import deque

queue = deque([start])
visited[start] = True

while queue:
    v = queue.popleft()
    for nxt in graph[v]:
        if not visited[nxt]:
            visited[nxt] = True
            queue.append(nxt)
```

---

# **7. DFS vs BFS 선택 기준**

1. **최단거리?**
    - YES → BFS
    - NO → 2번
2. **모든 경우를 봐야 하나?**
    - YES → DFS
    - NO → BFS 의심

---

# **8. 코테에서 자주 터지는 포인트 (중요)**

### **1) visited 처리 위치**

- DFS: **재귀 들어가기 전에**
- BFS: **큐에 넣을 때**

### **2) DFS 재귀 깊이**

```python
import sys
sys.setrecursionlimit(10**7)
```

- Python은 기본 재귀 제한 1000
- 그래도 **BFS가 안전한 경우 많다**.

---

# **9. 그래프 문제인데 사실상 BFS/DFS인 경우**

- 아래 유형은 **문제 설명에 DFS/BFS라는 말이 없어도** 거의 탐색 문제다.
    - 2차원 격자 (미로, 섬 개수)
    - 상태 전이 문제 (숫자 변환)
    - 퍼짐 문제 (불, 바이러스)
    - 연결 요소 개수

→ **그래프라고 생각 안 하면 틀린다.**

---

# **10. 실전 꿀팁 (중요)**

- **BFS = 최단거리 공식**
- DFS로 풀 수 있어도 **최단거리면 BFS가 정답**
- 2차원 문제는
    - dx, dy부터 선언
- 방문 배열
    - 단순 방문 → visited
    - 거리 필요 → dist
        
        ```python
        dist = [[-1]*m for _ in range(n)]
        ```