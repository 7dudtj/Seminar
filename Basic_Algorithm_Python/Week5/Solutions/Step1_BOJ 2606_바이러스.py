# 2606번 BFS로 풀어보기
# 빠르게 입력받기
import sys
input = sys.stdin.readline

# import deque
from collections import deque

# 컴퓨터의 수를 N으로 받으세요
N = int(input())

# 연결되어있는 컴퓨터의 쌍의 수를 M으로 받으세요
M = int(input())

# graph list를 선언하세요
graph = [[] for _ in range(N+1)] # 0 1 2 .. N-1 N / [ [] [] [] ... [] [] ]

# visited list를 선언하세요
visited = [False for _ in range(N+1)] # 0 1 2 .. N-1 N / [ False, False, False, ... False, False ]

# count 변수를 선언하세요
count = 0

# 연결되어있는 컴퓨터의 쌍을 입력받아서 그래프를 만드세요
for _ in range(M):
    node1, node2 = map(int, input().split()) # (node1)----(node2)
    graph[node1].append(node2) # node1 --> node2
    graph[node2].append(node1) # node2 --> node1 

# queue를 선언하세요
queue = deque()

# 1번 컴퓨터를 방문하세요
queue.append(1)
visited[1] = True

# bfs를 수행하세요
while queue: # queue가 남아있을 때
    v = queue.popleft() # 하나 뽑고
    count += 1
    for i in graph[v]: # v의 이웃 정점들 중에서
        if not visited[i]: # 방문이 안된 이웃을
            queue.append(i) # queue에 넣고
            visited[i] = True # 방문 여부 체크

# 결과를 출력하세요
print(count-1)