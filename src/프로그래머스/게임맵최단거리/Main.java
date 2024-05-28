package 프로그래머스.게임맵최단거리;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static int[][] visited;
    public static int[][] map;
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};
    public static int n;
    public static int m;

    public static void main(String[] args) {
        int answer = 0;
        n = 5;
        m = 5;

        int[][] visited = new int[n][m];

        map = new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        bfs(visited, map);

        answer = visited[n - 1][m - 1];

        System.out.println(Arrays.deepToString(visited));
    }

    public static void bfs(int[][] visited, int[][] map) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (map[ny][nx] == 1 && visited[ny][nx] == 0) {
                    visited[ny][nx] = visited[cur.y][cur.x] + 1;
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
