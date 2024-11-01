package 백준.테트로미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int[][] paper;
    public static int answer = Integer.MIN_VALUE;

    public static boolean[][] visited;

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 확인 - 20000
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, paper[i][j], 1); // 탐방하고 취소 처리 해야함
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int y, int x, int sum, int count) {
        if (count == 4) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                continue;
            }

            if (!visited[ny][nx]) { // 방문하지 않은 경우
                if (count == 2) { // 탐방 한번 더 진행 -> 3번째로 넘어가는게 아닌 2번째에서 재 탐색
                    visited[ny][nx] = true;
                    dfs(y, x, sum + paper[ny][nx], count + 1);
                    visited[ny][nx] = false;
                }

                // 나머지 탐방
                visited[ny][nx] = true;
                dfs(ny, nx, sum + paper[ny][nx], count + 1);
                visited[ny][nx] = false; // 탐방하고 초기화
            }
        }
    }
}