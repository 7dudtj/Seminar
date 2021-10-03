// skeleton code of boj_1920

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays; // 정렬을 위한 모듈
import java.util.StringTokenizer; // String을 Token화 해주는 모듈

// boj_1920 >> Main
public class boj_1920 {
  public static void main(String[] args) throws IOException {
    // set needed components
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    int N, M;
    int[] n, m;

    // get data
    N = Integer.parseInt(br.readLine());
    n = new int[N];
    st = new StringTokenizer(br.readLine(), " "); // " "을 기준으로 token화
    for (int i = 0; i < N; i++){
      n[i] = Integer.parseInt(st.nextToken()); // st에서 token을 하나씩 가져오기
    }
    /*
    마찬가지로, M과 M개의 수들도 똑같이 받아보세요!
    */
    
    // sort n
    Arrays.sort(n); // 이건 힌트입니다

    // do binary search for M times
    for (int i = 0; i < M; i++){
      int target = m[i];
      int answer = doBinarySearch(n, target);
      sb.append(answer).append('\n');
    }

    // print answer and end program
    System.out.print(sb);
    br.close();
    return;
  }

  // binary search function << 구현해보세요!
  public static int doBinarySearch(int[] n, int target){
    int left = 0;
    int right = n.length-1;
    int mid;

    while (right >= left){
      /*
      직접 구현해보세요!
      */
    }

    // not find target
    return 0;
  }
}