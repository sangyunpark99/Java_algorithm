package 백준.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int[][] map;
    public static int[][] visited;

    // 북,동,남,서
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        bfs(0, 0);
        
        System.out.println(visited[N - 1][M - 1]);
    }

    public static void bfs(int y, int x) {
        Node node = new Node(x, y);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited[y][x] = 1; // 시작지점

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (visited[ny][nx] == 0 && map[ny][nx] == 1) {
                    visited[ny][nx] = visited[cur.y][cur.x] + 1;
                    queue.add(new Node(nx, ny));
                }
            }

        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
