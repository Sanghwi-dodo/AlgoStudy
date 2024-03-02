import java.util.*;
import java.io.*;

public class BOJ_3024_Anhaechan {
	public static void main(String[] ewr) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 마라톤 틱택토

		int n = Integer.parseInt(br.readLine());
		char arr[][] = new char[n][n];
		// 틱택토 판 만들기
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		// 8방탐색 상하좌우 / 좌상 우상 좌하 우하
		int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dy[] = { 0, 0, 1, -1, -1, 1, -1, 1 };
		String res = "ongoing";

		ob: for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// .이 아닐때
				if (arr[i][j] != '.') {
					// 8방탐색
					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						// 값이 같을 때마다 cnt++ 후 
						int cnt = 1;
						while (nx >= 0 && ny >= 0 && nx < n && ny < n) {
								if (arr[i][j] != arr[nx][ny]) {
									break;
								}
									cnt++;
									// 틱택토 성공해서 다끝내는 break
									// nx ny 다음칸이동
									nx += dx[k];
									ny += dy[k];
							}
						if (cnt == n) {
							res = String.valueOf(arr[i][j]);
							break ob;
						}
						

					}
				}
			}
		}
		System.out.println(res);

	}
}
