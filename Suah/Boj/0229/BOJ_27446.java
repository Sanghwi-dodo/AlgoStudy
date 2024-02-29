import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] cntArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cntArr = new int[N + 1]; //있는 페이지는 카운트

        StringTokenizer tmp = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            cntArr[Integer.parseInt(tmp.nextToken())]++;
        }
        List<Integer> list = new ArrayList<>(); //없는 페이지 번호가 담긴 리스트
        for (int i = 1; i <= N; i++) {
            if (cntArr[i] == 0) {
                list.add(i);
            }
        }


        int last = 0; //가장 최근에 본 없는 페이지 번호
        int res = 0; //잉크 양
        for (int i: list) {
            if (last != 0) {
                res += Math.min(7, (i-last) * 2);
                // 완전히 새롭게 인쇄하는 것, 이전 페이지에 이어서 연속적으로 인쇄하는 것 중 잉크를 더 적게 사용하는 경우를 선택
            } else { //최근 목격한 페이지 번호 없을때
                res += 7; //완전히 새롭게 인쇄해야함
            }
            last = i;
        }
        System.out.println(res);
    }
}
