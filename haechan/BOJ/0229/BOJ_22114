import java.util.*;
import java.io.*;

public class BOJ_22114_Anhaechan {
	public static void main(String[] ewr) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 창영이와 점프

		StringTokenizer st = new StringTokenizer(br.readLine());
		// n 블럭 k 보폭
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[n - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int res = 0;
// 나머지로 순회하게하고싶은데
		for (int j = 0; j < n - 1; j++) {
			boolean superJmp = true;
			int jmp = 0;
			for (int i = 0; i < n - 1; i++) {
				// 시작값조정하자
				if (arr[(j+i)%arr.length] <= k) {
					jmp++;
				} else if (superJmp) {
					jmp++;
					superJmp = false;
				} else {
					break;
				}
			}
			if (jmp > res) {
				res = jmp;
			}
		}
		System.out.println(res + 1);
		
		// 1, 2, 3, 4, 5, 6
		// 시작점 = j 겉에 포문 1 / 2/  3/  4 / 5 / 6
		// j=3일때
		// arr[(j+i)%6]
		// 3+0일때 3 3+1일때 4 3+2일때 5 3+3일때 
		
	}
}
