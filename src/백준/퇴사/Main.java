package 백준.퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int answer = Integer.MIN_VALUE;
    public static int[][] arr = new int[20][2]; // t,p

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 상담을 이어서 안 할 수도 있다.
        get(0, 0); // 1일부터 시작

        System.out.println(answer);
    }

    public static void get(int i, int sum) {
        if (i >= N) { // 일자가 지나거나 당일인 경우
            answer = Math.max(answer, sum); // 최댓값 정리
            return;
        }

        if (i + arr[i][0] <= N) { // 이어서 할 경우
            get(i + arr[i][0], sum + arr[i][1]);
        } else { // 이어서 하는데 초과하는 경우
            get(i + arr[i][0], sum); // 끝내는 조건
        }

        get(i + 1, sum); // 띠엄띠험 해도 된다.
    }
}