// skeleton code of boj_10845

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// boj_10845 >> Main
public class boj_10845 {
	public static void main(String args[]) throws IOException {
	// set needed components
	// myQueue myQ = new myQueue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
	int N = Integer.parseInt(br.readLine());
	String pro;
		
	// do process for N times
	for (int i = 0; i < N; i++) {
		// get command
		pro = br.readLine();
			
		// process by command
		// if command is 'PUSH'
		if (pro.substring(0, 2).equals("pu")) {
                	int answer = 0;
			int pushNum = Integer.parseInt(pro.substring(5));
			/*
                	직접 해결해보세요!
                	*/
                	sb.append(answer).append('\n');
		}
		// if command is 'POP'
		else if (pro.equals("pop")) {
                	int answer = 0;
			/*
                	직접 해결해보세요!
                	*/
                	sb.append(answer).append('\n');
		}
		// if command is 'SIZE'
		else if (pro.equals("size")){
                	int answer = 0;
			/*
                	직접 해결해보세요!
                	*/
                	sb.append(answer).append('\n');
		}
		// if command is 'EMPTY'
		else if (pro.equals("empty")) {
                	int answer = 0;
			/*
                	직접 해결해보세요!
                	*/
                	sb.append(answer).append('\n');
		}
		// if command is 'FRONT'
		else if (pro.equals("front")) {
                	int answer = 0;
			/*
                	직접 해결해보세요!
                	*/
                	sb.append(answer).append('\n');
		}
		// if command is 'BACK'
		else if (pro.equals("back")) {
                	int answer = 0;
			/*
                	직접 해결해보세요!
                	*/
                	sb.append(answer).append('\n');
		}
	}
		
	// end program
        System.out.print(sb);
	br.close();
	return;
	}
}

/*
class myQueue{
    직접 구현해보세요!
}
*/
