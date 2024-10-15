package 백준.일로이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int N;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 3];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;

        for (int i = 2; i <= N; i++) { // dp 누적
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

        }

        System.out.println(dp[N]);

        go(N);

    }

    public static void go(int here) { // trace

        if (here == 0) {
            return;
        }
        System.out.printf("%d ", here);

        // trace
        if (here % 3 == 0 && dp[here] == dp[here / 3] + 1) {
            go(here / 3);
        } else if (here % 2 == 0 && dp[here] == dp[here / 2] + 1) {
            go(here / 2);
        } else if (here - 1 >= 0 && dp[here] == dp[here - 1] + 1) {
            go(here - 1);
        }
    }
}
