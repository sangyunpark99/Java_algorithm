package 백준.안전영역;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] map;
    public static int[][] visited;
    public static int answer;
    public static int rain = Integer.MIN_VALUE;

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                rain = Math.max(rain, map[i][j]);
            }
        }

        answer = 0;

        for (int i = 0; i <= rain; i++) { // 1~8
            int k = 0;
            for (int j = 0; j < N; j++) {
                for (int l = 0; l < N; l++) {
                    if (map[j][l] > i && visited[j][l] == 0) {
                        k++;
                        bfs(new Node(j, l), i);
                    }
                }
            }
            answer = Math.max(answer, k);
            visited = new int[N][N]; // 방문 초기화
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void bfs(Node node, int rain) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        visited[node.y][node.x] = 1; // 현재 노드 방문 추가

        while (!queue.isEmpty()) {

            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                    continue;
                }

                if (visited[ny][nx] == 0 && map[ny][nx] > rain) {
                    visited[ny][nx] = 1;
                    queue.add(new Node(ny, nx));
                }
            }
        }
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
