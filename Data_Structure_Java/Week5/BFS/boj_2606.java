// skeleton code of boj_2606

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue; // bfs로 풀 때에만 사용

// boj_2606 >> Main
// bfs 사용 코드
public class boj_2606 {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringTokenizer st;
    Queue<Integer> q = new LinkedList<>(); // bfs로 풀 때에만 사용
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    List<edge>[] adjList = new List[N+1];
    for (int i = 1; i <= N; i++) adjList[i] = new LinkedList<>();
    boolean[] visited = new boolean[N+1];
    int infection = 0, from, to;

    // make graph
    for (int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine(), " ");
      from = Integer.parseInt(st.nextToken());
      to = Integer.parseInt(st.nextToken());
      adjList[from].add(new edge(to));
      adjList[to].add(new edge(from));
    }

    // do bfs (class를 사용하지 않고 풀어봅시다!)
    q.add(1);
    visited[1] = true;
    while (!q.isEmpty()){
      /*
        bfs를 구현해보세요!
      */
    }

    // print answer and end program
    System.out.println(infection);
    br.close();
    return;
  }
}

// edge class
class edge{
  int adj; // adjacent vertex number
  public edge(int a){
    adj = a;
  }
}