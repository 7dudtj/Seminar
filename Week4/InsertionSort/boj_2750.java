// skeleton code of boj_2750

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// boj_2750 >> Main
public class boj_2750 {
  public static void main(String[] args) throws IOException {
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int[] list = new int[N];

    // get data
    for (int i = 0; i < N; i++){
        list[i] = Integer.parseInt(br.readLine());
    }

    // Insertion Sort
    /*
        삽입정렬을 직접 구현해보세요!
    */

    // print answer and end program
    for (int i = 0; i < N; i++) sb.append(list[i]).append('\n');
    System.out.print(sb);
    br.close();
    return;
  }
}