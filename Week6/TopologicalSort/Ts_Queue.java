package Week6.TopologicalSort; // 여기는 빼주셔도 됩니다

/*
Topological Sort - 위상정렬
수행시간 : O(N + M)
N : 정점의 수, M : 간선의 수행
*/

import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class Ts_Queue {
  // set static variables
  static int N = 9;
  static List<Integer>[] a;
  static int[] indegree;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args){
    a = new List[9];
    for (int i = 0; i < 9; i++) a[i] = new LinkedList<>();
    indegree = new int[9];

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
    indegree[0] = 1;
    indegree[1] = 2;
    indegree[2] = 0;
    indegree[3] = 2;
    indegree[4] = 1;
    indegree[5] = 1;
    indegree[6] = 1;
    indegree[7] = 2;
    indegree[8] = 1;

    ts();

    System.out.print(sb);
  }

  // topological sort function
  private static void ts(){
    // Queue 선언
    Queue<Integer> q = new LinkedList<>();

    // indegree가 0인 값들을 queue에 넣어주기
    for (int i = 0; i < N; i++){
      if (indegree[i] == 0) q.add(i);
    }

    // queue에서 poll하면서 탐색
    while (!q.isEmpty()){
      int node = q.poll();

      for (int v: a[node]){
        indegree[v]--;
        if (indegree[v] == 0) q.add(v);
      }

      sb.append(node).append(' ');
    }
  }
}