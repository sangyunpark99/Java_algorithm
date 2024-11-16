package 백준.안녕dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] cost;
    public static int[] happy;
    public static int answer = Integer.MIN_VALUE;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        // 최대 기쁨, 체력이 1 남을때까지 인사하기
        cost = new int[n];
        happy = new int[n];
        dp = new int[101];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 100; j > cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + happy[i]);
            }
        }

        System.out.println(dp[100]);
    }
}
