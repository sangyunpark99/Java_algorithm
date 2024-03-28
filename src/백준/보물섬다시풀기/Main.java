package 백준.보물섬다시풀기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static String[][] map;
    public static int N;
    public static int M;
    public static int res;
    public static int[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        res = 0;

        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ("L".equals(map[i][j])) {
                    res = Math.max(res, bfs(i, j));
                    visited = new int[N][M];
                }
            }
        }

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int y, int x) { // 최단거리

        int answer = 0;

        visited[y][x] = 1;
        Node node = new Node(y, x);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curNode.x + dx[i];
                int ny = curNode.y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[ny][nx] != 0 || "W".equals(map[ny][nx])) {
                    continue;
                }
                if (visited[ny][nx] == 0 && "L".equals(map[ny][nx])) {
                    visited[ny][nx] = visited[curNode.y][curNode.x] + 1;
                    answer = Math.max(answer, visited[ny][nx]);
                    queue.add(new Node(ny, nx));
                }
            }
        }

        return answer - 1;
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
