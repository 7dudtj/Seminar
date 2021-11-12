// skeleton code of boj_2252

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// boj_2252 >> Main
public class boj_2252 {
  // set static variables
  static int N;
  static List<Integer>[] graph;
  static StringBuilder sb = new StringBuilder();
  static int[] indegree;

  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int A, B;
    graph = new List[N];
    for (int i = 0; i < N; i++) graph[i] = new LinkedList<>();
    indegree = new int[N];

    // get graph
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      A = Integer.parseInt(st.nextToken());
      B = Integer.parseInt(st.nextToken());
      graph[A-1].add(B-1);
      indegree[B-1]++;
    }

    // do topological sort
    ts();

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }  

  // topological sort function
  public static void ts(){
    // set Queue
    Queue<Integer> q = new LinkedList<>();
    /*
        indegree값이 0인 노드를 q에 넣어주세요
    */

    // do topological sort
    while (!q.isEmpty()){
      int node = q.poll();

      /*
        topological sort를 구현해보세요!
      */
      
      // 정답을 stringbuilder에 담아주고 있습니다.
      sb.append(node + 1).append(" ");
    }
  }
}