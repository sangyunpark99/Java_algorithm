package 백준.구슬탈출2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;

    private static String[][] map;

    private static Marble red, blue;

    private static int[] dy = new int[]{-1, 0, 1, 0};
    private static int[] dx = new int[]{0, 1, 0, -1};
    private static boolean[][][][] visited;

    public static int holeY;
    public static int holeX;

    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new String[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
                if (map[i][j].equals("B")) {
                    blue = new Marble(0, 0, i, j, 0);
                } else if (map[i][j].equals("R")) {
                    red = new Marble(i, j, 0, 0, 0);
                } else if (map[i][j].equals("O")) { // 0이 아닌 O
                    holeY = i;
                    holeX = j;
                }
            }
        }

        System.out.println(bfs());
        br.close();
    }

    private static int bfs() { // 최단 경로 = BFS
        Queue<Marble> queue = new LinkedList<>();
        queue.add(new Marble(red.ry, red.rx, blue.by, blue.bx, 1));
        visited[red.ry][red.rx][blue.by][blue.bx] = true;

        while (!queue.isEmpty()) {
            Marble cur = queue.poll();

            int curRy = cur.ry;
            int curRx = cur.rx;
            int curBy = cur.by;
            int curBx = cur.bx;
            int curCnt = cur.cnt;

            if (curCnt > 10) { // 10회가 넘어간 경우
                return -1;
            }

            for (int i = 0; i < 4; i++) { // 방향 선택
                int newRy = curRy;
                int newRx = curRx;
                int newBy = curBy;
                int newBx = curBx;

                boolean redHole = false;
                boolean blueHole = false;

                // 빨간 구슬 이동
                while (!map[newRy + dy[i]][newRx + dx[i]].equals("#")) { // 빨간 구슬 이동
                    newRy += dy[i];
                    newRx += dx[i];

                    if (newRy == holeY && newRx == holeX) {
                        redHole = true;
                        break;
                    }
                }

                // 파란 구슬 이동
                while (!map[newBy + dy[i]][newBx + dx[i]].equals("#")) { // 파란 구슬 이동
                    newBy += dy[i];
                    newBx += dx[i];

                    if (newBy == holeY && newBx == holeX) { // 구멍에 빠진 경우
                        blueHole = true;
                        break;
                    }
                }

                // 파란 구슬이 빠진 경우
                if (blueHole) {
                    continue;
                }

                if (redHole && !blueHole) {
                    return curCnt;
                }

                if (newRy == newBy && newRx == newBx) { // 구멍에 안빠진 경우
                    if (i == 0) { // 위로 기울이기
                        if (curRy > curBy) { // 더큰 y값이 뒤로
                            newRy -= dy[i];
                        } else {
                            newBy -= dy[i];
                        }
                    } else if (i == 1) { // 오른쪽으로 기울이기 - 더 작은 값이 뒤로
                        if (curRx < curBx) {
                            newRx -= dx[i];
                        } else {
                            newBx -= dx[i];
                        }
                    } else if (i == 2) { // 아래로 기울이기 - 더 작은 값이 뒤로
                        if (curRy < curBy) {
                            newRy -= dy[i];
                        } else {
                            newBy -= dy[i];
                        }
                    } else { // 왼쪽으로 기울이기
                        if (curRx > curBx) {
                            newRx -= dx[i];
                        } else {
                            newBx -= dx[i];
                        }
                    }
                }

                if (!visited[newRy][newRx][newBy][newBx]) { // 방문하지 않은 경우
                    visited[newRy][newRx][newBy][newBx] = true;
                    queue.add(new Marble(newRy, newRx, newBy, newBx, curCnt + 1));
                }
            }
        }

        return -1; // 그외 모든 경우
    }

    private static class Marble {

        int ry;
        int rx;
        int by;
        int bx;
        int cnt;

        public Marble(int ry, int rx, int by, int bx, int cnt) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.cnt = cnt;
        }
    }
}