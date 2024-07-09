package 백준.게임_골드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 초과
public class Main {

    public static int N;
    public static int M;
    public static String[][] map;
    public static int[][] visited;

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static int moveMax = -2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        Node start = new Node(0, 0, Integer.parseInt(map[0][0]));

        bfs(start);

        System.out.println(moveMax);
    }

    public static void bfs(Node start) {
        // 모든 길을 탐색
        // 끝나거나 H를 만나면 그 지점 이동 횟수 더하기
        // 무한번 움직일 수 있는 기준을 어떻게 보지?
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int nxt = cur.num;
            int curY = cur.y;
            int curX = cur.x;

            for (int i = 0; i < 4; i++) {
                int nx = curX + nxt * dx[i];
                int ny = curY + nxt * dy[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx].equals("H")) {
                    moveMax = Math.max(visited[curY][curX] + 1, moveMax);
                } else {

                    visited[ny][nx] = visited[curY][curX] + 1;
                    queue.add(new Node(ny, nx, Integer.parseInt(map[ny][nx])));
                    if (map[curY][curX].equals(map[ny][nx])) { // 무한 반복
                        moveMax = -1;
                        return;
                    }
                }

            }
        }
    }

    public static class Node {
        int x;
        int y;
        int num;

        public Node(int y, int x, int num) {
            this.y = y;
            this.x = x;
            this.num = num;
        }
    }
}
