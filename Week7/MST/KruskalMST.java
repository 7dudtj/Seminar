/*
KruskalMST - Kruskal 알고리즘(최소신장트리)
수행시간 : O(MlogN)
N : 정점의 수, M : 간선의 수행
*/

import java.util.ArrayList;
import java.util.Collections;

public class Main {
  // set needed static components
  static int[] parent;

  public static void main(String[] args) {
    // set needed components
    int N = 7, M = 12, len = 0, count = 0;
    ArrayList<Edge> edgeList = new ArrayList<>();
    parent = new int[N];
    for (int i = 0; i < N; i++) parent[i] = i;

    // make edge
    Edge e1 = new Edge(0,1,9); Edge e2 = new Edge(0,2,10);
    Edge e3 = new Edge(1,4,5); Edge e4 = new Edge(4,2,7);
    Edge e5 = new Edge(4,6,1); Edge e6 = new Edge(5,2,2);
    Edge e7 = new Edge(6,5,6); Edge e8 = new Edge(1,6,3);
    Edge e9 = new Edge(1,3,10); Edge e10 = new Edge(6,3,8);
    Edge e11 = new Edge(5,3,4); Edge e12 = new Edge(2,3,9);

    // make edgeList
    edgeList.add(e1); edgeList.add(e2);
    edgeList.add(e3); edgeList.add(e4);
    edgeList.add(e5); edgeList.add(e6);
    edgeList.add(e7); edgeList.add(e8);
    edgeList.add(e9); edgeList.add(e10);
    edgeList.add(e11); edgeList.add(e12);
    Collections.sort(edgeList);

    // do KruskalMST
    for (int i = 0; i < edgeList.size(); i++){
      Edge e = edgeList.get(i);

      // check if edge creates cycle
      if (find(e.from) != find(e.to)){
        count++;
        len += e.weight;
        union(e.from, e.to);
      }
    }

    // print answer
    if (count == N-1) {
      System.out.println("All nodes are connected!\nLen of MST: "+len);
    } else{
      System.out.println("Some nodes are not connected!");
    }
  }  

  // find function for KruskalMST
  private static int find(int x){
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]);
  }

  // union function for KruskalMST
  private static void union(int a, int b){
    a = find(a);
    b = find(b);
    if (a != b) parent[b] = a;
  }
}

// Edge class
class Edge implements Comparable<Edge>{
  // class variables
  int from;
  int to;
  int weight;
  // constructor
  public Edge(int u, int v, int w){
    from = u;
    to = v;
    weight = w;
  }
  // Comparable
  @Override
  public int compareTo(Edge e){
    return weight - e.weight;
  }
}