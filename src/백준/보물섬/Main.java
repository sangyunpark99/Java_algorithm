package 백준.보물섬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    public static int N;
    public static int M;
    public static String[][] map;
    public static int ans;
    public static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        ans = Integer.MIN_VALUE;
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if ("L".equals(map[y][x])) {
                    ans = Math.max(ans, bfs(y, x));
                }
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int y, int x) { // 두 지점 사이의 최단거리를 구하면 된다.

        visited = new int[N][M]; // 방문 초기화

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int value = 1;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x)); // 시작 노드 삽입
        visited[y][x] = 1; // 방문처리

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M || "W".equals(map[ny][nx])) {
                    continue;
                }

                if (visited[ny][nx] == 0 && "L".equals(map[ny][nx])) { // 방문하지 않은 경우
                    visited[ny][nx] = visited[cur.y][cur.x] + 1;
                    queue.add(new Node(ny, nx));
                    value = Math.max(value, visited[ny][nx]);
                }
            }
        }

        return value - 1;
    }
}