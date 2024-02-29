package Study_01;
import java.util.*;
// 틀린부분 1. 44줄 // 로직 잘못 설정, 4장이상의 차이부터 손해가 발생하는데, 3장이상부터라 착각해서 계속 틀림. //
// 틀린부분 2. 53줄 // 마지막에 남는 페이지들에 대해 정확히 계산을 못했었음
// 틀린부분 3. 61줄 // 4 이상 차이로 , else 구문에걸리지 않는 경우, 마지막 한 페이지가 남는 경우를 제대로 계산하지 못했음.

public class BOJ27446_PASS {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        // 입력값 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        // 중복된 숫자 제거를위해 set을 설정함
        Set<Integer> set = new HashSet<>();
        // 내가 필요한 페이지를 찾아서 남기기 위해 배열 생성
        List<Integer> total = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            set.add(sc.nextInt());
        }

        // set에 없는 숫자들을 total에 담아줌으로서, 없는 페이지를 찾음
        for (int i = 1; i <= N; i++) {
            if (!(set.contains(i))) {
                total.add(i);
            }
        }
        // 불필요한 작업 ( 어차피 순서대로 담김)
        Collections.sort(total);

        // 페이지 잉크 합을 담기 위한 sum 변수 생성
        int sum = 0;

        // startIdx는, 로직상 한번에 인쇄하지 않는 페이지들을 구분할 때 사용
        int startIdx = 0;

        // i+1 번째와 비교하기 위하여 total.size() -1 까지 for문 돌림
        for (int i = 0 ; i < total.size() -1; i++) {

            // 다음 필요한 페이지와 4페이지 차이가 나면, 그때부턴 따로 찾는것이 유리함
            if (total.get(i+1) - total.get(i)>3) {
                // 페이지가 분리되는 i를 기준으로 시작 인쇄 시작페이지 까지 페이지 수를 cnt로 저장
                int cnt = total.get(i) - total.get(startIdx) + 1;
                sum += 5 + 2*cnt;
                // startIdx를 인쇄된 페이지 다음 번호로 이동
                startIdx = i+1;
            }
            else {
                // 3페이지를 초과하는 것 없이, i+1번째가, 마지막 페이지에 도달 했을때, 인쇄하지 않은 전체 페이지를 인쇄해야함
                if(i+1 == total.size()-1) {
                    int cnt = total.get(i+1) - total.get(startIdx) + 1;
                    sum += 5 + 2*cnt;
                }
            }
        }
        // 이 경우는 마지막 2개의 값이 , 4 이상의 차이가 날 경우, 앞에 것은 인쇄되지만, 마지막 숫자는 비교대상이 없어서 남게 됨.
        // 이러한 경우 마지막 페이지만 따로 출력할 필요가 있음(1페이지).
        if (startIdx == total.size()-1) {
            sum += 5 + 2;
        }
        System.out.println(sum);
    }
}
