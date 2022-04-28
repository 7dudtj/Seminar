// answer code of boj_1753

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

// boj_1753_ans >> Main
public class boj_1753_ans {
	public static void main(String args[]) throws IOException	{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    StringBuilder sb = new StringBuilder();
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());
    List<Edge>[] adjList = new List[V+1];
    for (int i = 1; i <= V; i++) adjList[i] = new LinkedList<>();
    int startPoint = Integer.parseInt(br.readLine());
    int[] distance = new int[V+1];
    boolean[] visited = new boolean[V+1];
    for (int i = 1; i <= V; i++) distance[i] = Integer.MAX_VALUE;

    // get map
    int u, v, w;
    for (int i = 0; i < E; i++){
      st = new StringTokenizer(br.readLine(), " ");
      u = Integer.parseInt(st.nextToken());
      v = Integer.parseInt(st.nextToken());
      w = Integer.parseInt(st.nextToken());
      adjList[u].add(new Edge(v, w));
    }

    // do Dijkstra
    distance[startPoint] = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
      @Override
      public int compare(Edge e1, Edge e2){
        return e1.w - e2.w;
      }
    });
    pq.add(new Edge(startPoint, 0));
    while (!pq.isEmpty()){
      Edge tmp = pq.poll();
      if (visited[tmp.adj]) continue;
      visited[tmp.adj] = true;
      for (Edge e: adjList[tmp.adj]){
        if (!visited[e.adj] && distance[tmp.adj] + e.w < distance[e.adj]){
          distance[e.adj] = distance[tmp.adj] + e.w;
          pq.add(new Edge(e.adj, distance[e.adj]));
        }
      }
    }

    // get answer
    for (int i = 1; i <= V; i++){
      if (distance[i] == Integer.MAX_VALUE) sb.append("INF\n");
      else sb.append(distance[i]+"\n");
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;  
  }
}

// Edge class
class Edge{
  int adj;
  int w;
  public Edge(int adj, int w){
    this.adj = adj;
    this.w = w;
  }
}