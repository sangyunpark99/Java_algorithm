package 백준.사다리타기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int H;
    public static int[][] visited;
    public static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        visited = new int[34][12];
        res = 4;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            visited[y][x] = 1;
        }

        dfs(1, 0);

        if (res == 4) {
            System.out.println(-1);
            return;
        }

        System.out.println(res);
    }

    public static boolean check() { // 사다리 탐색
        for (int i = 1; i <= N; i++) { // 시작점 i번째
            int start = i; // 시작 점
            for (int j = 1; j <= H; j++) { // 탐색 -> 가로로 이동하는 경우만 생각해주면 된다.(위에서부터)
                if (visited[j][start] == 1) { // 사다리가 놓인 경우
                    start++; // 오른쪽에 사다리가 놓인 경우, 오른쪽 이동
                } else if (visited[j][start - 1] == 1) { // 사다리가 놓이지 않은 경우
                    start--; // 왼쪽에 사다리가 놓인 경우, 왼쪽 아동
                }
            }

            if (start != i) {
                return false;
            }
        }

        return true;
    }

    public static void dfs(int here, int cnt) {
        if (cnt > 3 || cnt >= res) { // 가지치기
            return;
        }

        if (check()) { // 사다리 탐색
            res = Math.min(res, cnt);
            return;
        }

        for (int i = here; i <= H; i++) { // 세로당 놓을 수 있는 사다리 갯수
            for (int j = 1; j <= N; j++) {
                if (visited[i][j] != 0 || visited[i][j - 1] != 0 || visited[i][j + 1] != 0) { // 사다리를 놓을 수 있는 기준
                    continue;
                }
                visited[i][j] = 1;
                dfs(i, cnt + 1);
                visited[i][j] = 0;
            }
        }
    }
}