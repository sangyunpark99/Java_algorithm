package 백준.안전영역다시풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] map;
    public static int[][] visited;
    public static int res;

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int maxValue = Integer.MIN_VALUE;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                maxValue = Math.max(maxValue, value);
                map[i][j] = value;
            }
        }

        int answer = -1;

        for (int value = 0; value <= maxValue; value++) {
            visited = new int[N][N]; // 초기화
            int res = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > value && visited[j][k] == 0) {
                        dfs(j, k, value); // dfs 한번
                        res++;
                    }
                }
            }
            answer = Math.max(answer, res);
        }

        System.out.println(answer);
    }

    public static void dfs(int y, int x, int value) {

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] != 0 || map[ny][nx] <= value) {
                continue;
            }

            visited[ny][nx] = 1;
            dfs(ny, nx, value);
        }
    }
}