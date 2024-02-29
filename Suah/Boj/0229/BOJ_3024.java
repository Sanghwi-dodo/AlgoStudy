import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for (int r=0; r<N; r++) {
            String tmp = br.readLine();
            for (int c=0; c<N; c++) {
                board[r][c] = tmp.charAt(c);
            }
        }
        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
        boolean flag = false;
        int resr = -1;
        int resc = -1;

        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                if (board[r][c] != '.') { //이름 들어있다면 팔방 탐색 시작
                    start: for (int d=0; d<8; d++) {
                        for (int i=1; i<3; i++) {
                            int nr = r + dr[d]*i;
                            int nc = c + dc[d]*i;
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                                if (board[nr][nc] != board[r][c]) continue start;
                            } else continue start;
                        }
                        resr = r;
                        resc = c;
                        flag = true;

                    }
                }
            }
        }
        if (flag) System.out.println(board[resr][resc]);
        else System.out.println("ongoing");
    }
}
