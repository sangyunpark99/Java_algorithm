package 백준.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final int[] dx = {0, 1, 0, -1};
    public static final int[] dy = {-1, 0, 1, 0};
    public static int[][] map;
    public static int[][] visited;
    public static int n, m;
    public static int res = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        findWall(0);

        System.out.println(res);
    }

    public static void findWall(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    findWall(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = map[i].clone(); // 일차원 배열 초기화 - 원본을 유지하기 위해 clone() 사용
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }
                if (copy[ny][nx] == 0) {
                    queue.add(new Node(ny, nx));
                    copy[ny][nx] = 2;
                }
            }
        }

        findSafe(copy);
    }

    public static void findSafe(int[][] copy) {

        int safeZone = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        res = Math.max(res, safeZone);
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