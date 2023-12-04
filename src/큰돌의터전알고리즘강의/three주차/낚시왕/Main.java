package 큰돌의터전알고리즘강의.three주차.낚시왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 이동할때는 안잡아 먹힌다.
    public static int R, C, M;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};
    public static int answer = 0;
    public static Shark[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            map[r][c] = new Shark(r, c, s, d, z);
        }

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (map[j][i] != null) { // 상어 제거
                    answer += map[j][i].z;
                    map[j][i] = null;
                    break;
                }

            }

            moveShark();
        }

        System.out.println(answer);
    }

    public static void moveShark() {

        Queue<Shark> sharks = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != null) {
                    sharks.add(new Shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
                }
            }
        }

        map = new Shark[R][C];

        while (!sharks.isEmpty()) {
            Shark cur = sharks.poll();

            int speed = cur.s;
            int dir = cur.d;

            if (dir == 0 || dir == 1) {
                speed %= 2 * (R - 1);
            } else if (dir == 2 || dir == 3) {
                speed %= 2 * (C - 1);
            }

            for (int s = 0; s < speed; s++) {
                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) { // 벽을 넘은경우
                    cur.r -= dr[dir];
                    cur.c -= dc[dir];
                    cur.d = changeDir(dir);
                    continue;
                }

                cur.r = nr;
                cur.c = nc;
            }

            if (map[cur.r][cur.c] != null) {

                if (map[cur.r][cur.c].z < cur.z) {
                    map[cur.r][cur.c] = new Shark(cur.r, cur.c, cur.s, cur.d, cur.z);
                }
            } else {
                map[cur.r][cur.c] = new Shark(cur.r, cur.c, cur.s, cur.d, cur.z);
            }
        }
    }

    public static int changeDir(int n) {
        if (n == 1) {
            return 0;
        } else if (n == 0) {
            return 1;
        } else if (n == 2) {
            return 3;
        }

        return 2;
    }

    static class Shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
