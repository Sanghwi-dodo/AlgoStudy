import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N-1];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int n=0; n<N-1; n++) {
            arr[n] = Integer.parseInt(st2.nextToken());
        }
        int maxCnt = -1;
        int sidx = 0;
        while (sidx < N-1) {
            int jump = 0; //점프 초기화
            int cnt = 1; //연속 밟을 수 있는 횟수 카운트
            for (int i=sidx; i<N-1; i++) {
                if (arr[i] <= K) { //배열 숫자가 보폭보다 작거나 같으면 이동 가능
                    cnt++;
                } else {
                    if (jump < 1) { //점프 한번은 쓸 수 있음
                        jump++;
                        cnt++;
                    }
                    else break; //점프 이미 썼으면 이제 끝
                }
            }
            maxCnt = Math.max(cnt,maxCnt);
            if (maxCnt > N - sidx) break; //현재 인덱스에서 최대로 건널수 있는 수보다 지금 카운트가 더 크면 굳이 안돌아도됨
            sidx++;
        }
        System.out.println(maxCnt);
    }
}
