package 백준.게임_골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 초과
public class Main {

    public static int N;
    public static int M;
    public static String[][] map;
    public static boolean[][] visited;
    public static int[][] dp;

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static int max = -2;

    public static boolean isCycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N][M];
        map = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        visited[0][0] = true;
        dfs(0, 0, 1);

        if (isCycle) {
            max = -1;
        }

        System.out.println(max);
    }

    public static void dfs(int y, int x, int moveCnt) {
        int nxtCnt = Integer.parseInt(map[y][x]);
        dp[y][x] = moveCnt;

        if (moveCnt > max) {
            max = moveCnt;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + nxtCnt * dy[i];
            int nx = x + nxtCnt * dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) { // 범위를 초과한 경우
                continue;
            }

            if (map[ny][nx].equals("H")) { // H를 만난 경우
                continue;
            }

            if (moveCnt < dp[ny][nx]) { // 이미 큰 경우는 가지치기
                continue;
            }

            if (visited[ny][nx]) { // 방문한 곳 또 방문한 경우
                isCycle = true;
                return;
            }

            visited[ny][nx] = true; // 방문 처리
            dfs(ny, nx, moveCnt + 1);
            visited[ny][nx] = false; // 방문 처리 취소
        }
    }
}
