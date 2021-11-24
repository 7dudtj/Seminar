/*
DijkstraSP - Dijkstra 알고리즘(최단경로)
수행시간 : O(NlogN)
N : 정점의 수
PriorityQueue를 사용하여, 시간복잡도를 O(N^2)에서 O(NlogN)으로 낮춤
*/

import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Dijkstra {
  public static void main(String[] args){
    // set needed components
    int N = 6;
    int[] distance = new int[N];
    boolean[] visited = new boolean[N];
    for (int i = 0; i < N; i++){
      distance[i] = Integer.MAX_VALUE;
      visited[i] = false;
    }
    List<Edge>[] adjList = new List[N];
    for (int i = 0; i < N; i++) adjList[i] = new LinkedList<>();
    int startPoint = 0;

    // get Edges
    Edge e11 = new Edge(4, 3); Edge e12 = new Edge(3, 3);
    Edge e21 = new Edge(3, 0); Edge e22 = new Edge(1, 0);
    Edge e31 = new Edge(0, 4); Edge e32 = new Edge(3, 4);
    Edge e41 = new Edge(0, 1); Edge e42 = new Edge(1, 1);
    Edge e51 = new Edge(5, 1); Edge e52 = new Edge(4, 1);
    Edge e61 = new Edge(5, 2); Edge e62 = new Edge(2, 2);
    Edge e71 = new Edge(1, 6); Edge e72 = new Edge(2, 6);
    Edge e81 = new Edge(3, 4); Edge e82 = new Edge(2, 4);

    // make adjList
    adjList[3].add(e11); adjList[4].add(e12);
    adjList[1].add(e21); adjList[3].add(e22);
    adjList[3].add(e31); adjList[0].add(e32);
    adjList[1].add(e41); adjList[0].add(e42);
    adjList[4].add(e51); adjList[5].add(e52);
    adjList[2].add(e61); adjList[5].add(e62);
    adjList[2].add(e71); adjList[1].add(e72);
    adjList[2].add(e81); adjList[3].add(e82);

    // do Dijkstra
    distance[startPoint] = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>(){
      @Override
      public int compare(Edge e1, Edge e2){
        return e1.weight - e2.weight;
      }
    });
    pq.add(new Edge(startPoint, 0));
    while (!pq.isEmpty()){
      Edge temp = pq.poll();
      if (visited[temp.adjvertex]) continue;
      visited[temp.adjvertex] = true;
      for (Edge e: adjList[temp.adjvertex]){
        if (!visited[e.adjvertex] && distance[temp.adjvertex] + e.weight < distance[e.adjvertex]){
          distance[e.adjvertex] = distance[temp.adjvertex] + e.weight;
          pq.add(new Edge(e.adjvertex, distance[e.adjvertex]));
        }
      }
    }

    // print data
    System.out.println("Start Point : "+startPoint);
    for (int i = 0; i < distance.length; i++) System.out.println("Distance to "+i+": "+distance[i]);
  } 
}

// Edge class
class Edge{
  int adjvertex;
  int weight;
  public Edge(int adj, int w){
    adjvertex = adj;
    weight = w;
  }
}