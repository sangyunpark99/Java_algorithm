package 백준.일이더하기사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // 1,2,3으로 더해지는 수
        int[][] dp = new int[10004][4];

        // 아래에 존재하는 수들은 전부 1개씩 존재한다.
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1]; // 각 경우에 1을 더하는 경우
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2]; // 각 경우에 2를 더하는 경우
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
            // 3은 왜 3개인가? 3을 나타내는 경우는 3가지이다. 1+1+1, 2+1, 3
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int value = dp[n][1] + dp[n][2] + dp[n][3];

            sb.append(value);
            if (i < T - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
