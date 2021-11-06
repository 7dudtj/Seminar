// skeleton code of boj_2606

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
//import java.util.Queue; << BFS로 풀 때에만 사용

// boj_2606 >> Main
public class boj_2606 {
  // 함수에서의 접근을 위한 변수 설정
  static boolean[] visited;
  static List<Edge>[] adjList;
  static int infection = 0;
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringTokenizer st;
    //Queue<Integer> q = new LinkedList<>(); << BFS로 풀 때에만 사용
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
    visited = new boolean[N+1];
    int from, to;

    // make graph
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      adjList[from].add(new Edge(to));
      adjList[to].add(new Edge(from));
    }

    // do dfs
    dfs(1);

    // print answer and end program
    System.out.println(infection-1);
    br.close();
    return;
  }

  // dfs function
  private static void dfs(int v){
    /*
      dfs를 구현해보세요!
    */
  }
}

// Edge class
class Edge{
  int adj; // adjacent vertex number
  public Edge(int a){
    adj = a;
  }
}