package 백준.불;

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

// 불이 하나, 또는 여러개인 경우를 고려
public class Main {

    public static int R, C;
    public static char[][] map;
    public static int[][] fireVisited;
    public static int[][] humanVisited;

    public static List<Node> fires = new ArrayList<>();

    public static final int[] dy = {-1, 0, 1, 0};
    public static final int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireVisited = new int[R][C];
        humanVisited = new int[R][C];

        Node human = new Node(0, 0);

        for (int i = 0; i < R; i++) {
            String value = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = value.charAt(j);

                if (ch == 'F') { // 불 좌
                    fires.add(new Node(i, j));
                } else if (ch == 'J') { // 사람 좌표
                    human = new Node(i, j);
                }

                map[i][j] = ch; // 맵 그리기
            }
        }

        for (Node node : fires) { //불이 여러개인 경우
            fireVisited[node.y][node.x] = 1;
        }
        // 불이 번지는 최단경로 구하기
        fireBfs();

        humanVisited[human.y][human.x] = 1;
        // 사람이 이동하는 최단경로 구하기
        humanBfs(human);

        // 두 최단경로를 비교해서 결과 도출하기 - 맵의 가장자리를 탐색?
        int answer = Integer.MAX_VALUE;

        // 1. 불이 지나가지 않은 자리인데 사람이 지나간 경우
        // 2. 불도 지나가고 사람도 지나가는 자리
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == R - 1 || i == 0 || j == C - 1 || j == 0) { // 가장자리 인경우
                    if (humanVisited[i][j] > 0) {
                        if (fireVisited[i][j] == 0) {
                            answer = Math.min(answer, humanVisited[i][j]);
                        } else {
                            if (humanVisited[i][j] < fireVisited[i][j]) {
                                answer = Math.min(answer, humanVisited[i][j]);
                            }
                        }

                    }
                }
            }
        }

        if (answer != Integer.MAX_VALUE) {
            bw.write(answer + "\n");
        } else {
            bw.write("IMPOSSIBLE");
        }

        bw.close();
        br.close();
    }

    public static void fireBfs() {
        Queue<Node> queue = new LinkedList<>();

        for (Node node : fires) {
            queue.add(node);
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            int curY = cur.y;
            int curX = cur.x;

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == '#') {
                    continue;
                }

                if (fireVisited[ny][nx] == 0) {
                    fireVisited[ny][nx] = fireVisited[curY][curX] + 1;
                    queue.add(new Node(ny, nx));
                }
            }
        }
    }

    public static void humanBfs(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            int curY = curNode.y;
            int curX = curNode.x;

            for (int i = 0; i < 4; i++) {
                int ny = curY + dy[i];
                int nx = curX + dx[i];

                if (ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == '#') {
                    continue;
                }

                if (humanVisited[ny][nx] == 0) { // 아직 지나가지 않았다면
                    humanVisited[ny][nx] = humanVisited[curY][curX] + 1; // 이전 경로 +1
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
