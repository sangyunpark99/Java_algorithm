package 백준.경로찾기1513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int mod = 100007;

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

        game = new int[51][51]; // 오락기 위치
        dp = new int[51][51][51][51]; // y,x,cnt,prev

        for (int i = 1; i <= c; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            game[r][c] = i;
        }

        for (int i = 0; i < c; i++) { // 오락실을 갯수별로
            System.out.printf("%d ", go(1, 1, i, 0));
        }
    }

    public static int go(int y, int x, int cnt, int prev) { // 오락실 갯수별로
        if (y > n || x > m) { // 맵의 범위를 벗어난 경우
            return 0;
        }
        if (y == n & x == m) { // 학원에 도착한 경우
            if (cnt == 0 && game[y][x] == 0) {
                return 1;
            }
            if (cnt == 1 && game[y][x] > prev) { //
                return 1;
            }
            return 0;
        }

        int ret = dp[y][x][cnt][prev]; // 지난 값 누적
        if (ret != -1) {
            return ret;
        }
        ret = 0;
        if (game[y][x] == 0) { // 오락실이 아닌 경우
            ret = (go(y + 1, x, cnt, prev) + go(y, x + 1, cnt, prev)) % mod;
        } else if (game[y][x] > prev) { // 오락실인 경우
            ret = go(y + 1, x, cnt - 1, game[y][x]) + go(y, x + 1, cnt - 1, game[y][x]) % mod;
        }

        return ret;
    }
}
