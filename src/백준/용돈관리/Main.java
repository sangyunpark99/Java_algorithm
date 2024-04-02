package 백준.용돈관리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int answer;
    public static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        money = new int[N];

        int start = 1;
        int end = 10_000 * 100_000;

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, money[i]);
        }

        // 최소 금액을 찾으면 된다.

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean check(int mid) {
        int k = 1; // 맨 처음 1번 인출
        int value = mid; // 값 초기화
        for (int i = 0; i < N; i++) {
            if (value - money[i] < 0) {
                value = mid;
                k++;
            }

            value -= money[i];
        }

        return k <= M; // 인출 횟수가 적다 = 돈이 많이 남아돈다 -> 돈의 크기를 줄여야한다.
    }
}
