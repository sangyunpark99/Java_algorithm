package 백준.경로찾기1513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int mod = 1_000_007;

    public static int n;
    public static int m;
    public static int c;
    public static int[][][][] dp;
    public static int[][] game;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        game = new int[51][51];
        dp = new int[51][51][51][51];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        for (int i = 1; i <= c; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            game[r][c] = i;
        }

        for (int i = 0; i <= c; i++) { // 오락실 갯수별로 탐색
            System.out.printf("%d ", go(1, 1, i, 0));
        }
    }

    public static int go(int y, int x, int cnt, int prev) {
        if (y > n || x > m) {
            return 0;
        }

        if (cnt < 0) {
            return 0;
        }

        if (dp[y][x][cnt][prev] != -1) {
            return dp[y][x][cnt][prev];
        }

        if (y == n && x == m) {
            if (cnt == 0 && game[y][x] == 0) {
                return 1;
            }
            if (cnt == 1 && game[y][x] > prev) {
                return 1;
            }
            return 0;
        }

        int result = 0;
        if (game[y][x] == 0) {
            result = (go(y + 1, x, cnt, prev) + go(y, x + 1, cnt, prev)) % mod;
        } else if (game[y][x] > prev) {
            result = (go(y + 1, x, cnt - 1, game[y][x]) + go(y, x + 1, cnt - 1, game[y][x])) % mod;
        }

        dp[y][x][cnt][prev] = result;
        return result;
    }
}