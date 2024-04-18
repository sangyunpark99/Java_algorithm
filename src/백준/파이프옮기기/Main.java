package 백준.파이프옮기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 방법의 갯수를 누적시켜주면 된다.

    public static int N;
    public static int[][] map;
    public static int[][][] dp;

    // 0 : 가로, 1: 세로, 2: 대각선
    public static int check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][2][0] = 1;

        // 0 -> 가로, 1 -> 세로, 2 -> 대각선
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] == 1) { // 벽이 존재하는 경우 넘어가
                    continue;
                }

                // 가로로 올 수 있는 경우 : 가로 -> 가로, 대각선 -> 가로
                dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];

                // 세로로 올 수 있는 경우 : 세로 -> 세로, 대각선 -> 세로
                dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];

                // 대각선으로 올 수 있는 경우 : 대각선 -> 대각선, 세로 -> 대각선, 가로 -> 대각선
                if (map[i - 1][j] == 0 && map[i][j - 1] == 0) { // 대각선인 경우에는 옆,위,도 비어있어야 한다.
                    dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
        br.close();
    }
}