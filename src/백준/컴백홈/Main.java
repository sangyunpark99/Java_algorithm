package 백준.컴백홈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int R;
    public static int C;
    public static int K;

    public static String[][] map;
    public static int[][] visited;

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{-1, 0, 1, 0};

    public static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().split("");
        }

        visited[R - 1][0] = 1;
        dfs(R - 1, 0);

        bw.write(res + "\n");
        bw.close();
        br.close();
    }

    public static void dfs(int y, int x) {
        if (y == 0 && x == C - 1) { // 도착지점에 도착한 경우

            if (visited[y][x] == K) {
                res++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C || "T".equals(map[ny][nx]) || visited[ny][nx] > 0) {
                continue;
            }

            visited[ny][nx] = visited[y][x] + 1; // 방문처리
            dfs(ny, nx);
            visited[ny][nx] = 0; // 원상 복구 처리
        }
    }
}