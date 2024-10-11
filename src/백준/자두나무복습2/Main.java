package 백준.자두나무복습2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int T;
    public static int W;

    public static int[] zadu;

    public static int[][][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        zadu = new int[T + 1]; // 0초부터가 아닌, 1초부터 시작하기 위해서

        for (int i = 1; i <= T; i++) {
            zadu[i] = Integer.parseInt(br.readLine());
        }

        // 위치, 시간, 이동 횟수
        dp = new int[3][T + 1][W + 2];

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) { // 맨처음 움직이지 않은 경우를 1로 본다.
                if (zadu[i] == 1) {
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
                } else {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]) + 1;
                }
            }
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i <= T; i++) {
            answer = Math.max(dp[1][i][W + 1], dp[2][i][W + 1]);
        }

        System.out.println(answer);
    }
}
