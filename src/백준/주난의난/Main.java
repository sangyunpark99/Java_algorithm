package 백준.주난의난;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;

    public static Position junan;
    public static Position target;

    public static String[][] map;
    public static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        junan = new Position(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        target = new Position(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        map = new String[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split("");
        }

        visited = new int[N][M];

        bfs();
    }

    public static void bfs() {
        Queue<Position> q = new LinkedList<>();
        q.add(junan);
        visited[junan.y][junan.x] = 1; // 주난이 방문처리

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int turn = 0;

        while (!map[target.y][target.x].equals("0")) { // 목표지점이 0이 안될때 까지
            turn++;
            Queue<Position> tmp = new LinkedList<>(); // 다음에 출발해야 하는 지점 추가하기
            while (!q.isEmpty()) {
                Position cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] > 0) {
                        continue;
                    }
                    visited[ny][nx] = turn;

                    if (!map[ny][nx].equals("0")) {
                        map[ny][nx] = "0";
                        tmp.add(new Position(ny, nx));
                    } else {
                        q.add(new Position(ny, nx));
                    }
                }
            }

            q = tmp; // 다음 이동해야할 지점 초기화
        }

        System.out.println(turn);
    }

    public static class Position {
        int x;
        int y;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
