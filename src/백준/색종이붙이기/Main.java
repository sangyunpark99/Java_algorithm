package 백준.색종이붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map;
    private static int n = 10;
    private static int ret = Integer.MAX_VALUE;
    private static int[] mpValue = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 색종이 최소 갯수 -> 제일 큰 색종이 갯수 부착
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        if (ret == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        System.out.println(ret);
    }

    private static void dfs(int y, int x, int cnt) { // 이차원 배열 탐색
        if (ret <= cnt) { // 백트래킹
            return;
        }

        if (x == n) { // x가 마지막이면 y+1
            dfs(y + 1, 0, cnt);
            return;
        }

        if (y == n) { // y가 마지막이면 끝
            ret = Math.min(ret, cnt);
            return;
        }

        if (map[y][x] == 0) { // 0이라면
            dfs(y, x + 1, cnt);
            return;
        }

        for (int size = 5; size >= 1; size--) {
            if (mpValue[size] == 5) {
                continue;
            }
            if (check(y, x, size)) {
                mpValue[size]++;
                draw(y, x, size, 0); // 그림 그리기
                dfs(y, x + size, cnt + 1); // 색종이 그린
                draw(y, x, size, 1); // 그림 취소
                mpValue[size]--;
            }
        }
    }

    private static void draw(int y, int x, int size, int value) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                map[i][j] = value;
            }
        }
    }

    private static boolean check(int y, int x, int size) { // 기준점을 맨위
        if (y + size - 1 >= n || x + size - 1 >= n) {
            return false;
        }

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (map[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}