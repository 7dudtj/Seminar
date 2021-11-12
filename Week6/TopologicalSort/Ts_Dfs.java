package Week6.TopologicalSort; // 여기는 빼주셔도 됩니다

/*
Topological Sort - 위상정렬
수행시간 : O(N + M)
N : 정점의 수, M : 간선의 수행
*/

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class Ts_Dfs {
  public static void main(String[] args) {
    List<Integer>[] a = new List[9];
    for (int i = 0; i < 9; i++) a[i] = new LinkedList<>();
    List<Integer> answer = new ArrayList<>();

    a[2].add(1);
    a[2].add(0);
    a[0].add(1);
    a[1].add(3);
    a[1].add(4);
    a[4].add(5);
    a[5].add(3);
    a[5].add(7);
    a[3].add(6);
    a[6].add(7);
    a[7].add(8);

    TopologicalSort ts = new TopologicalSort(a);
    answer = ts.tsort();
    System.out.println("위상정렬:");
    for (int v: answer) System.out.print(v+" ");
  }  
}

class TopologicalSort{
  int N; // 그래프의 정점 수
  boolean[] visited; // DFS 수행 중 방문여부 체크 용
  List<Integer>[] adjList; // 인접리스트 형태의 입력 그래프
  List<Integer> sequence; // 위상정렬 순서를 담을 리스트
  // 생성자
  public TopologicalSort(List<Integer>[] graph){
    N = graph.length;
    visited = new boolean[N];
    adjList = graph;
    sequence = new ArrayList<>();
  }
  public List<Integer> tsort(){ // 위상정렬을 위한 DFS 수행
    for (int i = 0; i < N; i++) if (!visited[i]) dfs(i);
    Collections.reverse(sequence); // sequence를 역순으로 만들기
    return sequence;
  }
  public void dfs(int i){ // DFS 수행
    visited[i] = true;
    for (int v: adjList[i]){ // i의 방문이 끝나고 앞으로 방문해야하는 각 정점 v에 대해
      if (!visited[v]) dfs(v);
    }
    sequence.add(i); // i에서 진출하는 간선이 더 이상 없으므로 i를 sequence에 추가
  }
}