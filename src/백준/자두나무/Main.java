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

        zadu = new int[T + 1]; // 1초부터 시작

        for (int i = 1; i <= T; i++) {
            zadu[i] = Integer.parseInt(br.readLine());
        }

        // 나무 위치 | 시간 | 움직임
        int[][][] dp = new int[3][T + 1][W + 2]; // 움직임이 없는 경우가 0 이되면 -1을 할경우 오류가 발생한다.

        for (int i = 1; i <= T; i++) { // 시간에 따른
            for (int j = 1; j <= W + 1; j++) { // 움직임
                if (zadu[i] == 1) { // 1번 나무 위치에 자두가 존재한다면
                    // 1번나무에서 가만히 있음으로 자두를 먹가나 2번나무에서 1번나무로 이동해서 자두를 먹은 갯수중 최댓값으로 갱신
                    dp[1][i][j] = Math.max(dp[1][i - 1][j] + 1, dp[2][i - 1][j - 1] + 1);
                    // 2번 나무에서 가만히 있는 경우와 1번 나무에서 2번나무로 이동한 경우 중 최댓값으로 갱신
                    dp[2][i][j] = Math.max(dp[2][i - 1][j], dp[1][i - 1][j - 1]);
                } else { // 2번나무에 자두가 존재한다면
                    if (i == 1 && j == 1) { // 자두는 1번 자두나무 아래에 위치 --> 2번 자두나무로 갈 수 없다.
                        continue;
                    }
                    // 1번 나무에서 가만히 있는 경우와 2번 나무에서 1번나무로 이동한 경우 중 최댓값으로 갱신
                    dp[1][i][j] = Math.max(dp[1][i - 1][j], dp[2][i - 1][j - 1]);
                    // 2번 나무에서 가만히 자두를 먹는 경우와 1번 나무에서 2번 나무로 옮겨서 자두를 먹은 갯수의 최댓값으로 갱신
                    dp[2][i][j] = Math.max(dp[2][i - 1][j] + 1, dp[1][i - 1][j - 1] + 1);
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= W; i++) {
            result = Math.max(result, Math.max(dp[1][T][i], dp[2][T][i]));
        }

        System.out.println(result);
        br.close();
    }
}
