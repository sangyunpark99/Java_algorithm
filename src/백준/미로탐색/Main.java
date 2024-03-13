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

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

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

        bfs();

        System.out.println(visited[N - 1][M - 1]);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(0, 0); // 시작지점
        queue.add(node);
        visited[node.y][node.x] = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (map[ny][nx] == 1 && visited[ny][nx] == 0) { // 이동할 수 있고, 방문을 하지 않은 경우
                    visited[ny][nx] = visited[cur.y][cur.x] + 1; // 한개 증가시켜준다.
                    queue.add(new Node(ny, nx));
                }
            }
        }
    }

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
