package 백준.용돈관리복습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];

        int end = 100000 * 10000; // 최대 금액
        int res = 0;
        int start = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, money[i]);
        }

        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(mid)) {
                end = mid - 1;
                res = mid;
            } else {
                start = mid + 1;
            }
        }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean check(int mid) {
        int cnt = 1; // 시작 인출
        int value = mid;

        for (int i = 0; i < N; i++) {
            if (value - money[i] < 0) { // 0보다 작은 경우
                cnt++;
                value = mid;
            }

            value -= money[i];
        }

        return cnt <= M; // cnt가 더 적다는 의미는? 인출을 더 적게했다. 액수가 크다
    }
}
