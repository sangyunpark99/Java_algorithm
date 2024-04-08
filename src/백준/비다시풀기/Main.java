package 백준.비다시풀기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// DFS로 풀어보자
public class Main {

    public static int N;
    public static int[][] map;
    public static int[][] visited;

    // 북, 동, 남, 서
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];

        int maxRain = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxRain = Math.max(maxRain, map[i][j]);
            }
        }

        int result = Integer.MIN_VALUE;

        for (int rain = 0; rain <= maxRain; rain++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (visited[j][k] == 0 && map[j][k] > rain) {
                        visited[j][k] = 1;
                        dfs(j, k, rain);
                        cnt++;
                    }
                }
            }

            result = Math.max(result, cnt);
            visited = new int[N][N];
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int y, int x, int rain) {

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (visited[ny][nx] == 0 && map[ny][nx] > rain) {
                visited[ny][nx] = 1; // 방문 처ㅇ
                dfs(ny, nx, rain);
            }
        }
    }
}
