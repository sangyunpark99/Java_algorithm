package 백준.유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int T;
    public static int M;
    public static int N;
    public static int K;

    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken()); // 세로 길이
            N = Integer.parseInt(st.nextToken()); // 가로 길이
            K = Integer.parseInt(st.nextToken()); // 위치의 갯수

            // 초기화
            map = new int[M][N];
            visited = new boolean[M][N];
            int count = 0;
            for (int j = 0; j < K; j++) { // 초기화
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && map[j][k] == 1) { // 방문하지 않은 곳
                        dfs(j, k);
                        count++; // dfs 탈출 하면 카운터 증가
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= M || nx < 0 || nx >= N) {
                continue;
            }

            if (map[ny][nx] == 1 && !visited[ny][nx]) {
                dfs(ny, nx); // 깊이 우선 탐색
            }
        }
    }
}
