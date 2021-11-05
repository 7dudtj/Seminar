/*
DFS - 깊이우선탐색
수행시간 : O(N + M)
N : 정점의 수, M : 간선의 수행
*/

import java.util.List;
import java.util.LinkedList;

public class myDFS {
  public static void main(String[] args) {
    int N = 10;
    List<Edge>[] adjList = new List[N];
    for (int i = 0; i < N; i++){
      adjList[i] = new LinkedList<>();
    }
    Edge e1 = new Edge(1); Edge e2 = new Edge(2);
    adjList[0].add(e1); adjList[0].add(e2);
    Edge e11 = new Edge(0); Edge e22 = new Edge(0);
    adjList[1].add(e11); adjList[2].add(e22);
    Edge e3 = new Edge(1); Edge e4 = new Edge(2);
    adjList[3].add(e3); adjList[3].add(e4);
    Edge e33 = new Edge(3); Edge e44 = new Edge(3);
    adjList[1].add(e33); adjList[2].add(e44);
    Edge e5 = new Edge(3); Edge e6 = new Edge(3);
    adjList[8].add(e5); adjList[9].add(e6);
    Edge e55 = new Edge(8); Edge e66 = new Edge(9);
    adjList[3].add(e55); adjList[3].add(e66);
    Edge e7 = new Edge(5); Edge e8 = new Edge(5);
    adjList[4].add(e7); adjList[6].add(e8);
    Edge e77 = new Edge(4); Edge e88 = new Edge(6);
    adjList[5].add(e77); adjList[5].add(e88);
    Edge e9 = new Edge(5); Edge e0 = new Edge(6);
    adjList[7].add(e9); adjList[7].add(e0);
    Edge e99 = new Edge(7); Edge e00 = new Edge(7);
    adjList[5].add(e99); adjList[6].add(e00);

    DFS callDFS = new DFS(adjList);
  }  
}

class Edge{
  int adjvertex; // 간선의 다른쪽 정점
  // 생성자
  public Edge(int v){
    adjvertex = v;
  }
}

class DFS{
  int N; // 그래프 정점의 수
  List<Edge>[] graph;
  private boolean[] visited; // DFS 수행 중 방문한 정점을 true로 만든다
  // 생성자
  public DFS(List<Edge>[] adjList){
    N = adjList.length;
    graph = adjList;
    visited = new boolean[N];
    for (int i = 0; i < N; i++) visited[i] = false; // 배열 초기화
    for (int i = 0; i < N; i++) if (!visited[i]) dfs(i);
  }
  private void dfs(int i){
    visited[i] = true; // 정점 i가 방문되어 visited[i]를 true로
    System.out.print(i+" "); // 정점 i가 방문되었음을 출력
    for (Edge e: graph[i]){ // 정점 i에 인접한 각 정점에 대해
      if (!visited[e.adjvertex]){ // 정점 i에 인접한 정점이 방문 안되었으면 재귀호출
        dfs(e.adjvertex);
      }
    }
  }
}