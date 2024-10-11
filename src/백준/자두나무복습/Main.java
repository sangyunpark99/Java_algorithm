package 백준.자두나무복습;

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

        zadu = new int[T + 1]; // 0초부터가 아닌, 1초부터 시작하기 위해서

        for (int i = 1; i <= T; i++) {
            zadu[i] = Integer.parseInt(br.readLine());
        }

        // 위치 - 1아니면 2, 시간, 움직임
        int[][][] dp = new int[3][T + 1][W + 2];

        // 0부터 시작하면 index = -1이되서 오류가 발생할 수도..?

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) { // 이동하는 횟수 만큼
                if (zadu[i] == 1) { // T초에 자두의 위치가 1인 경우
                    // 1번->1번(현재위치), 2번->1번(현재위치) (자두 획득 O)
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]) + 1;
                    // 1번->2번(현재위치), 2번->2번(현재위치) (자두 획득 X)
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]);
                } else { // T초에 자두의 위치가 2인 경우
                    if (i == 1 && j == 1) { // 자두는 1번 자두나무 아래에 위치 --> 2번 자두나무로 갈 수 없다.
                        continue;
                    }
                    // 1번->1번(현재위치), 2번->1번(현재위치) (자두 획득 X)
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    // 1번->2번(현재위치), 2번->2번(현재위치) (자두 획득 O)
                    dp[2][i][j] = Math.max(dp[1][i - 1][j - 1], dp[2][i - 1][j]) + 1;
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= W + 1; i++) {
            result = Math.max(result, Math.max(dp[1][T][i], dp[2][T][i]));
        }

        System.out.println(result);
        br.close();
    }
}