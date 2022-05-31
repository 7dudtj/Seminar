# 2606번 DFS로 풀어보기
# 빠르게 입력받기
import sys
input = sys.stdin.readline

# dfs 함수를 만드세요
def dfs(graph, v, visited): # v번 정점 탐색하러 들어왔을 때
    global count
    visited[v] = True # 탐색했으니까 방문 여부 체크
    for i in graph[v]: # v의 이웃 정점들 중에서
        if not visited[i]: # 방문이 되지 않은 정점이 있다면
            count += 1
            dfs(graph, i, visited) # 방문되지 않은 이웃 정점을 dfs로 탐색

# 컴퓨터의 수를 N으로 받으세요
N = int(input())

# 연결되어있는 컴퓨터의 쌍의 수를 M으로 받으세요
M = int(input())
 
# graph list를 선언하세요
graph = [[] for _ in range(N+1)] # 0 1 2 .. N-1 N / [ [] [] [] ... [] [] ]

# visited list를 선언하세요
visited = [False for _ in range(N+1)] # 0 1 2 .. N-1 N / [ False, False, False, ... False, False ]

# count 변수를 선언하세요 (global variable)
count = 0
 
# 연결되어있는 컴퓨터의 쌍을 입력받아서 그래프를 만드세요
for _ in range(M):
    node1, node2 = map(int, input().split()) # (node1)----(node2)
    graph[node1].append(node2) # node1 --> node2
    graph[node2].append(node1) # node2 --> node1

# dfs를 수행하세요
dfs(graph, 1, visited) # 1: 탐색의 시작 지점

# 결과를 출력하세요
print(count)