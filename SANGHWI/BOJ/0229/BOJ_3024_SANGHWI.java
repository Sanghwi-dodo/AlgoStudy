package Study_01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3024_PASS {

    public static void main(String[] args) throws IOException {
        int cnt = 0;

        // 월말평가 1번과 유사문제 //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 8방탐색   왼위, 위  오위, 왼, 오 왼아,아 오아
        int[] dx = {-1,-1,-1,0,0,1,1,1 };
        int[] dy = {-1,0,1,-1,1,-1,0,1 };

        char[][] map = new char[N][];

        // char 배열 (보드판) 생성
        // char 배열 제대로 담긴거 확인o
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 승리한 사람이 없을땐 ongoing이므로, ans를 ongoing으로 초기화
        String ans = "ongoing";
        // 완전탐색 진행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char tmp = map[i][j];
                // 판의 값이 '.' 일 경우, 탐색안함.
                if (tmp != '.') {
                    for (int k = 0; k <8; k++) {
                        cnt = 0;
                        // 수정 포인트 2 //
                        // 연속된 3개의 값만 체크하면 되므로 탐색범위를 최대 3까지로 수정
                        for (int l = 1; l < 3; l++) {
                            // 옆칸과 옆옆칸 (8방) 확인 (l = 1, 2)
                            int nx = i + (dx[k] * l);
                            int ny = j + (dy[k] * l);
                            // 경계범위 지정
                            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                                // 자기자신(tmp)와 동일할 때, cnt++
                                if (tmp == (map[nx][ny])) {
                                    cnt++;
                                }
                                // tmp와 다른값이 나오면, 연속값이 아니기에 바로 break후 다음 델타 배열 탐색
                                else {
                                    break;
                                }
                            }
                            else {
                                break;
                            }
                        }
                        // 틀린포인트 //
                        // 문제를 잘못읽음. cnt 를 N-1로 지정했었는데
                        // 3개의 숫자만 연속하면 되는 문제
                        // cnt =2 는, 옆칸, 옆옆칸이 자기자신과 같을때, 즉 연속된 3개의 값을 보장.
                        if (cnt == 2) {
                            ans = String.valueOf(tmp);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
