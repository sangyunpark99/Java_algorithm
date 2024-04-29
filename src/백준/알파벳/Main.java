package 백준.알파벳;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int R;
    public static int C;
    public static char[][] map;
    public static int cnt = 1;

    public static int res;

    public static int[] dy = new int[]{-1, 0, 1, 0};
    public static int[] dx = new int[]{0, 1, 0, -1};

    public static ArrayList<String> alphabet = new ArrayList<>();
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new int[26];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited[map[0][0] - 'A'] = 1;

        res = -1;

        dfs(0, 0, 1);

        bw.write(res + "\n");
        bw.close();
        br.close();
    }

    public static void dfs(int y, int x, int cnt) {

        res = Math.max(res, cnt);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited[map[ny][nx] - 'A'] > 0) {
                continue;
            }

            if (visited[map[ny][nx] - 'A'] == 0) {
                visited[map[ny][nx] - 'A'] = 1;
                dfs(ny, nx, cnt + 1);
                visited[map[ny][nx] - 'A'] = 0;
            }
        }
    }
}
