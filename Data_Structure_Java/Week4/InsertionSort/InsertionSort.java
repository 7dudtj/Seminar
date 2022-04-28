/*
삽입정렬 (Insertion Sort)
수행시간 : O(N^2)
*/

public class InsertionSort {
  public static void main(String[] args) {
    Insertion in = new Insertion();
    int[] list = new int[7];
    list[0] = 70; list[1] = 60; list[2] = 40;
    list[3] = 50; list[4] = 10; list[5] = 30; list[6] = 20;
    in.sort(list);
    for (int i = 0; i < 7; i++) System.out.print(list[i]+" ");
  }  
}

class Insertion{
  public void sort(int[] a){
    int N = a.length;
    for (int i = 1; i < N; i++){ // i는 현재 원소의 인덱스
      for (int j = i; j > 0; j--){ // 현재 원소를 정렬된 앞부분에 삽입
        if (isless(a[j], a[j-1])) swap(a, j, j-1);
        else break;
      }
    }
  }
  // 키 비교
  private boolean isless(int i, int j){
    return i < j;
  }
  // 원소 교환
  private void swap(int[] a, int i, int j){
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}