package 백준.자두나무;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int T;
    public static int W;
    public static int[] drop;
    public static int[][][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        drop = new int[T + 1];

        memo = new int[3][T + 1][W + 2];

        for (int i = 1; i <= T; i++) {
            drop[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= T; i++) {
            for (int j = 1; j <= W + 1; j++) {
                if (drop[i] == 1) {
                    memo[1][i][j] = Math.max(memo[1][i - 1][j], memo[2][i - 1][j - 1]) + 1;
                    memo[2][i][j] = Math.max(memo[2][i - 1][j], memo[1][i - 1][j - 1]);
                } else {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    memo[1][i][j] = Math.max(memo[1][i - 1][j], memo[2][i - 1][j - 1]);
                    memo[2][i][j] = Math.max(memo[2][i - 1][j], memo[1][i - 1][j - 1]) + 1;
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= W + 1; i++) {
            result = Math.max(result, Math.max(memo[1][T][i], memo[2][T][i]));
        }

        System.out.println(result);
    }
}
