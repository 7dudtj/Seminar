/*
BFS - 너비우선탐색
수행시간 : O(N + M)
N : 정점의 수, M : 간선의 수행
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class myBFS {
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

    BFS callBFS = new BFS(adjList);
  }  
}

class Edge{
  int adjvertex; // 간선의 다른쪽 정점
  // 생성자
  public Edge(int v){
    adjvertex = v;
  }
}

class BFS{
  int N; // 그래프 정점의 수
  List<Edge>[] graph;
  private boolean[] visited; // BFS 수행 중 방문한 정점의 원소를 true로 만든다
  // 생성자
  public BFS(List<Edge>[] adjList){
    N = adjList.length;
    graph = adjList;
    visited = new boolean[N]; // false
    for (int i = 0; i < N; i++) visited[i] = false; // 배열 초기화
    for (int i = 0; i < N; i++) if (!visited[i]) bfs(i);
  }
  private void bfs(int i){
    Queue<Integer> q = new LinkedList<Integer>(); // 큐 선언
    visited[i] = true;
    q.add(i); // 큐에 시작 정점 삽입
    while (!q.isEmpty()){
      int j = q.remove(); // 큐에서 정점 j를 가져옴
      System.out.print(j+" "); // 정점 j가 방문되었음을 출력
      for (Edge e: graph[j]){ // 정점 j에 인접한 정점들 중 방문안된 정점 하나씩 방문
        if (!visited[e.adjvertex]){
          visited[e.adjvertex] = true;
          q.add(e.adjvertex); // 새로이 방문된 정점을 큐에 삽입
        }
      }
    }
  }
}