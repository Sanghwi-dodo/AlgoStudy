import java.util.*;
import java.io.*;

public class BOJ_27446_Anhaechan  {
	public static void main(String[] ewr) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 랩실

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 논문의 마지막 페이지 번호
		int n = Integer.parseInt(st.nextToken());
		// 바닥에 흩어진 논문의 장수
		int m = Integer.parseInt(st.nextToken());

		// 연속된 k장 = 5+2k
		// 한장 7 두장 9 세장 11  네장 13 15
		// 한장 7 두장 14
		
		//  o o o o x o o x o
		// 14 vs 중간에 두칸이면 연속으로 하는게 이득13
		int [] arr = new int [n+1];
		
		st= new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			int a = Integer.parseInt(st.nextToken());
			arr[a]++;
		}
		
		// list로 빈칸 idx 받기
		List<Integer> list = new ArrayList<>();
		for(int i=1;i<n+1;i++) {
			if(arr[i]==0) {
				list.add(i);
			}
		}
		// 잉크 결과 : res  , 최근 idx :  last
		int res=0;
		int last=0;
		
		for(int i=0; i<list.size();i++) {
			if(last==0) {
				res+=7;
			}else {
				res+=Math.min(7,(list.get(i)-last)*2 );
			}
			last=list.get(i);
		}
		System.out.println(res);
		

	}
}
