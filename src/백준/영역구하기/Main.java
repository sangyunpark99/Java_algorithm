package 백준.영역구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int M;
    public static int N;
    public static int K;

    public static int[][] visited;
    public static int[][] map;
    public static int size = 1;

    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{-1, 0, 1, 0};

    public static List<Integer> emptySizes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[M][N];
        map = new int[M][N];
        emptySizes = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());

            // 색칠하기
            for (int j = leftY; j < rightY; j++) {
                for (int k = leftX; k < rightX; k++) {
                    map[j][k] = 1; // 직사각형 처리
                }
            }
        }

        int res = 0;

        // 구간 탐색
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && visited[i][j] == 0) {
                    visited[i][j] = 1; // 방문처리하고
                    emptySizes.add(dfs(i, j));
                    res++;
                    size = 1; // 초기화
                }
            }
        }

        Collections.sort(emptySizes); // 정렬
        System.out.println(res);

        for (int i = 0; i < emptySizes.size(); i++) { // 너비 출력
            System.out.print(emptySizes.get(i) + " ");
        }

    }

    // 너비를 어떻게 더해줄까?

    public static int dfs(int y, int x) {

        int size = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= M || nx >= N) {
                continue;
            }
            if (map[ny][nx] == 0 && visited[ny][nx] == 0) { // 방문하지 않은 곳인 경우
                visited[ny][nx] = 1;
                size += dfs(ny, nx); // 너비
            }
        }
        return size;
    }
}