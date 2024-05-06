package 백준.유기농배추다시풀기1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int T;
    public static int M;
    public static int N;
    public static int K;

    public static int[][] map;
    public static int[][] visited;

    public static List<Point> list = new ArrayList<>(); // 배추가 심긴 장소

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        visited = new int[M][N];

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int res = 0;

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            visited = new int[M][N];
            map = new int[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
                list.add(new Point(y, x));
            }

            for (int j = 0; j < list.size(); j++) {
                Point point = list.get(j);
                if (visited[point.y][point.x] == 0) {
                    visited[point.y][point.x] = 1;
                    res += dfs(point.y, point.x);
                }
            }

            list.clear();

            bw.write(res + "\n");
        }

        bw.close();
        br.close();
    }

    public static int dfs(int y, int x) {

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= M || nx < 0 || nx >= N || visited[ny][nx] > 0) {
                continue;
            }
            if (map[ny][nx] == 1) { // 배춧닢이면
                visited[ny][nx] = 1;
                dfs(ny, nx);
            }
        }

        return 1;
    }

    public static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
