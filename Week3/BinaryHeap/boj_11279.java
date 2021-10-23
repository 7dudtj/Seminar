// skeleton code of boj_11279

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// boj_11279 >> Main
public class boj_11279 {
  public static void main(String[] args) throws IOException{
    // set needed variables
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int input;
    Entry[] a = new Entry[N+1];
    BHeap bh = new BHeap(a, 0);

    // do process
    for (int i = 0; i < N; i++){
      input = Integer.parseInt(br.readLine());

      /*
        직접 구현해보세요!
      */
    }

    // end program
    br.close();
    return;
  }
}

// Entry class
class Entry <Key extends Comparable<Key>>{
  /*
    직접 구현해보세요!
  */
}

// Binary_Max_Heap class
class BHeap <Key extends Comparable<Key>>{
  private Entry[] a; // a[0]은 사용 안함
  private int N; // 힙의 크기, 즉, 힙에 있는 항목 수
  // 생성자
  public BHeap(Entry[] harray, int initialSize){
    a = harray;
    N = initialSize;
  }
  public int size(){return N;} // 힙의 크기 리턴
  // 키 비교
  private boolean greater(int i, int j){
    // 직접 구현해보세요
  }
  // a[i]와 a[j]를 교환
  private void swap(int i, int j){
    // 직접 구현해보세요
  }
  // 초기 힙 만들기
  public void createHeap(){
      // 직접 구현해보세요
  }
  private void downheap(int i){ // i는 현재 노드의 인덱스
    // 직접 구현해보세요
  }
  // 새로운 항목 삽입
  public void insert(Key newKey){
      // 직접 구현해보세요
  }
  private void upheap(int j){ // j는 현재 노드의 인덱스
    // 직접 구현해보세요   
  }
  // 최댓값 삭제
  public Entry deleteMax(){
      // 직접 구현해보세요
  }
}