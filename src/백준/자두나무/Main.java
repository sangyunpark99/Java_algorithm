package 백준.자두나무;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int T;
    public static int W;
    public static int[] zadu;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        zadu = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            zadu[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[3][T + 1][W + 2];

        for (int i = 1; i <= T; i++) { // 시간
            for (int j = 1; j <= W + 1; j++) { // 이동 횟수
                if (zadu[i] == 1) {
                    // 가만히 있다가 먹거나 아니면 이동해서 먹거나 둘 중 큰걸로 먹어~
                    dp[1][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1);
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
                } else {
                    if (i == 1 && j == 1) { // 어차피 못먹어~
                        continue;
                    }
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1] + 1, dp[2][i - 1][j] + 1);
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= W + 1; i++) {
            result = Math.max(result, Math.max(dp[1][T][i], dp[2][T][i]));
        }

        System.out.println(result);
    }
}
