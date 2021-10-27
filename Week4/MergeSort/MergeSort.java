/*
합병정렬 (Merge Sort)
수행시간 : O(NlogN)
*/

public class MergeSort {
  public static void main(String[] args) {
    Merge mg = new Merge();
    int[] list = new int[8];
    list[0] = 80; list[1] = 40; list[2] = 50; list[3] = 10;
    list[4] = 70; list[5] = 20; list[6] = 30; list[7] = 60;
    mg.sort(list);
    for (int i = 0; i < 8; i++) System.out.print(list[i]+" ");
  }  
}

class Merge{
  private void merge(int[] a, int[] b, int low, int mid, int high){
    int i = low, j = mid + 1;
    for (int k = low; k <= high; k++){
      if (i > mid) b[k] = a[j++]; // 앞부분이 먼저 소진된 경우
      else if (j > high) b[k] = a[i++]; // 뒷부분이 먼저 소진된 경우
      else if (isless(a[j], a[i])) b[k] = a[j++]; // a[j]가 승자
      else b[k] = a[i++]; // a[i]가 승자
    }
    for (int k = low; k <= high; k++) a[k] = b[k]; // 보조배열 b를 배열 a에 복사
  }
  private void sort(int[] a, int[] b, int low, int high){
    if (high <= low) return;
    int mid = low + (high - low)/2;
    sort(a, b, low, mid); // 앞부분 재귀호출
    sort(a, b, mid+1, high); // 뒷부분 재귀호출
    merge(a, b, low, mid, high); // 합병 수행
  }
  public void sort(int[] a){
    int[] b = new int[a.length];
    sort(a, b, 0, a.length-1);
  }
  private boolean isless(int v, int w){
    return v < w;
  }
}
