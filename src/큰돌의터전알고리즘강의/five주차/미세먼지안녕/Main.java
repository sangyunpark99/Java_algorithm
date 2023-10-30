package 큰돌의터전알고리즘강의.five주차.미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int R, C, T, map[][];
    private static int cleaner = -1;
    private static Queue<Dust> dusts;
    private static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};

    private static class Dust {
        int x, y, w;

        public Dust(int y, int x, int w) {
            this.y = y;
            this.x = x;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        dusts = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (cleaner == -1 && map[i][j] == -1) {
                    cleaner = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            checkDust();
            spread();
            windTop();
            windBottom();
        }

        int res = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
                if (map[i][j] == -1) {
                    continue;
                }
                res += map[i][j];
            }
            System.out.println();
        }

        System.out.println(res);
    }

    private static void checkDust() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1 || map[i][j] == 0) {
                    continue;
                }
                dusts.add(new Dust(i, j, map[i][j]));
            }
        }
    }

    private static void spread() {
        while (!dusts.isEmpty()) {
            Dust cur = dusts.poll();
            if (cur.w < 5) {
                continue;
            }
            int amountSpread = cur.w / 5;
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
                    continue;
                }
                if (map[ny][nx] == -1) {
                    continue;
                }

                map[ny][nx] += amountSpread;
                cnt++;
            }

            map[cur.y][cur.x] -= amountSpread * cnt;
        }
    }

    private static void windTop() {
        int top = cleaner;
        // 아래로 당기기
        for (int i = top - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }

        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }

        // 위로 당기기
        for (int i = 0; i < top; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }

        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) {
            map[top][i] = map[top][i - 1];
        }

        map[top][1] = 0; // 깨끗한 공간
    }

    private static void windBottom() {
        int bottom = cleaner + 1;

        // 위로 당기기
        for (int i = bottom + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        // 아래로 당기기
        for (int i = R - 1; i > bottom; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) {
            map[bottom][i] = map[bottom][i - 1];
        }

        map[bottom][1] = 0; // 깨끗한 공간
    }
}
