package 큰돌의터전알고리즘강의.five주차.미세먼지안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static List<Integer> cleanerY;

    private static int R;
    private static int C;
    private static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        cleanerY = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == -1) {
                    cleanerY.add(i);
                }

                if (cleanerY.size() == 2) { // 더이상 탐지할 필요가 없다.
                    break;
                }
            }
        }

        // 1. 먼지 탐방
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                spreadDust(i, j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        // 2. 청소기로 먼지 돌리기
        //firstWindMove();
        //secondWindMove();
    }

    private static void spreadDust(int curY, int curX) { // 먼지 움직이게 하기

        int[] dy = new int[]{-1, 0, 1, 0};
        int[] dx = new int[]{0, 1, 0, -1};

        int dustDegree = map[curY][curX];

        int spreadDirection = 0;

        for (int i = 0; i < 4; i++) { // 4방향 확산
            int ny = curY + dy[i];
            int nx = curX + dx[i];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == -1) { // 범위 만족
                continue;
            }

            spreadDirection++;
            map[ny][nx] += (int) (dustDegree / 5);
        }

        map[curY][curX] = dustDegree - dustDegree / 5 * spreadDirection;
    }

    private static void firstWindMove() {
        // 외곽만 땡기면된다.
        for (int i = cleanerY.get(0); i > 0; i--) { // 위 -> 아래
            map[i][0] = map[i - 1][0];
        }

        for (int i = 1; i < map[0].length - 1; i++) { // 오 -> 왼
            map[0][i] = map[0][i + 1];
        }

        for (int i = 1; i < cleanerY.get(0); i++) {  // 아래 -> 위
            map[i][0] = map[i + 1][0];
        }

        for (int i = map[0].length - 1; i > 0; i++) {
            map[0][i] = map[0][i - 1];
        }
        //청소기 위치 계속 -1로 초기화
        map[0][cleanerY.get(1)] = -1;
    }

    private static void secondWindMove() {
        // 외곽만 땡기면된다.
        for (int i = cleanerY.get(1); i < map.length - 1; i++) {  // 아래 -> 위
            map[i][0] = map[i + 1][0];
        }

        for (int i = 0; i < C - 1; i++) { // 오 -> 왼
            map[R - 1][i] = map[R - 1][i + 1];
        }

        for (int i = R - 1; i >= cleanerY.get(1); i--) { // 위 -> 아래
            map[i][0] = map[i - 1][0];
        }

        for (int i = C - 1; i > 0; i++) { // 왼 -> 오
            map[cleanerY.get(1)][i] = map[cleanerY.get(i)][i - 1];
        }

        //청소기 위치 계속 -1로 초기화
        map[0][cleanerY.get(1)] = -1;
    }
}
