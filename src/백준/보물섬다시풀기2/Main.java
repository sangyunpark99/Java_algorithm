package 백준.보물섬다시풀기2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;

    public static String[][] map;
    public static int[][] visited;

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static List<Node> treasures = new ArrayList<>();
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] list = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = list[j];
                String value = list[j];
                if (value.equals("L")) {
                    treasures.add(new Node(i, j));
                }
            }
        }

        for (Node node : treasures) {
            bfs(node);
        }

        bw.write(answer - 1 + "\n");
        bw.close();
        br.close();
    }

    public static void bfs(Node start) { // 최단 경로 구하기

        Queue<Node> queue = new LinkedList<>();
        visited[start.y][start.x] = 1; // 방문 처리
        queue.add(start);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }
                if (!map[ny][nx].equals("W") && visited[ny][nx] == 0) { // 방문하지 않은 곳만
                    visited[ny][nx] = visited[cur.y][cur.x] + 1; // 거리 누적하기
                    answer = Math.max(answer, visited[ny][nx]);
                    queue.add(new Node(ny, nx));
                }
            }
        }

        visited = new int[N][M]; // 초기화
    }

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
