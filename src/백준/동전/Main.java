package 백준.동전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        int[] dp = new int[10001];

        // 경우의 수 = 누적

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(br.readLine());
            for (int j = temp; j <= k; j++) {
                dp[j] += dp[j - temp];
            }
        }

        System.out.println(dp[k]);
    }

}
