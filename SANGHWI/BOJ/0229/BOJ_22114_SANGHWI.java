package Study_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ22114_PASS {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        // 풀이 전략
        // 첫 블록과 마지막 블록, 양쪽 끝 블록은, 가장많이 이동한 기준점이 될 가능성이 크기에 ArrayList 담길수 있도록 수치를 조정함
        // 처음, 사이간격 배열에 담을 때, K+1로 초기화 함.
        // N개의 숫자는, 돌사이의 거리를 표현하기에, N+1 의 배열로, 돌의 배열로 표시

        // list 배열은, 사이간격을 나타내는, 즉 입력값을 받는 배열
        int[] list = new int[N+1];
        // 첫돌
        list[0] = K+1;
        // 마지막 돌
        list[N] = K+1;
        for (int i = 1; i < N; i++) {
            list[i] = Integer.parseInt(st2.nextToken());
        }

        // 리스트를 순회하면서, 그 값이 보폭(K) 보다 큰 경우, ArrayList에 그 값의 index를 저장
        // 몇 개의 값이 입력되는지 알 수 없으므로 ArrayList로 지정.
        List<Integer> checkPoint = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            if(list[i] > K) {
                checkPoint.add(i);
            }
        }

        // 한번은 점프로, 넘어갈 수 있음, 따라서 첫 값부터 index +2 값과의 거리를 측정
        // 거리로 측정 하므로 양 방향을 순회할 필요가 없음.
        int max = 0;
        for (int i = 0; i < checkPoint.size()-2; i++) {
            int tmp = checkPoint.get(i+2) - checkPoint.get(i);
            if (tmp > max) {
                max = tmp;
            }
        }

        // 빼먹어서 틀렸던 곳
        // -> 예외 사항을 고려 안해서 틀림
        // 빨간 블록이 모드 점프 범위 이내이 있는 경우가 존재 -> 모든 N개의 블록 이동 가능
        // ArrayList에는 첫 값과 끝 값 (N)의 길이, 가 항상 포함되므로, 중간에 2개의 값이 추가 되어야 중간에 멈춤.
        // 기준값이 4인 이유는, 처음과 끝 돌울, 무조건 보폭보다 큰 값으로 지정하여 ArrayList로 담아놨기 때문에,
        // check.point.size()가 3인경우, 첫 값과, 뛰어넘을 수 있는 값, 그리고 마지막값 으로 전체를 다 이동 가능함.
        if (checkPoint.size() < 4 ) {
            max = N;
        }
        System.out.println(max);
    }
}

