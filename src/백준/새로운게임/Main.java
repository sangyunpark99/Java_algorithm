package 백준.새로운게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int k;
    private static int[][] color; // 맵 색깔
    private static int[][] horses;
    private static LinkedList<Integer>[][] map; // 말 쌓기
    private static int[] dy = {0, 0, -1, 1};
    private static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        color = new int[n][n];
        horses = new int[k][3];
        map = new LinkedList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new LinkedList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;

            horses[i][0] = y;
            horses[i][1] = x;
            horses[i][2] = dir;

            map[y][x].add(i); // 말 넣기
        }

        game();
    }

    private static void game() {
        for (int turn = 1; turn <= 1000; turn++) {
            for (int horse = 0; horse < k; horse++) {
                int y = horses[horse][0];
                int x = horses[horse][1];
                int dir = horses[horse][2];
                int num = getSequence(horse, y, x);

                // 이동
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                // 맵을 초과하거나 파란색 칸을 만난것은 같은 취급
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || color[ny][nx] == 2) {
                    // 0, 1, 2, 3
                    // 동, 서, 북, 남
                    // 반대 방향 처리
                    // 0 -> 1, 1 -> 0, 2 -> 3, 3 -> 2
                    horses[horse][2] = dir = dir ^ 1; // XOR 연산으로 방향
                    // 반대 방향으로 이동
                    ny = y + dy[dir];
                    nx = x + dx[dir];

                    // 반대 방향으로 이동했는데 맵을 넘어가거나 파란색을 만난 경우
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || color[ny][nx] == 2) {
                        continue; // 이동 x
                    }
                }
                // 이동 -> 빨간색 칸일 경우 reverse, 흰색 칸일 경우 위에 있는 말들이랑 같이 이동
                if (move(y, x, ny, nx, num, color[ny][nx])) {
                    System.out.println(turn);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    private static boolean move(int y, int x, int ny, int nx, int num, int color) {
        while (map[y][x].size() > num) { // 지금 말 부터, 위에 있는말 옮기기
            int temp = -1; // 말을 옮기기 위한 중간 값
            if (color == 0) { // 흰색 칸인 경우
                temp = map[y][x].remove(num); // 말의 번호, 삭제하면, 위의 말이 내려옴
            } else { // 빨간색 칸인 경우
                // 마지막 말부터 삭제해서 쌓아준다.
                temp = map[y][x].removeLast();
            }

            // 말 위치 변경
            horses[temp][0] = ny;
            horses[temp][1] = nx;
            map[ny][nx].add(temp); // 이동할 칸에 말 쌓기
        }

        // 말이 4마리 이상 있는 경우
        if (map[ny][nx].size() >= 4) { // 말이 4개가 쌓이는 경우
            return true; // 턴 종료
        }

        return false;
    }

    private static int getSequence(int horseNumber, int y, int x) { // 현재 말이 몇번째에 쌓여 있는지 확인
        for (int i = 0; i < map[y][x].size(); i++) {
            if (map[y][x].get(i) == horseNumber) {
                return i;
            }
        }

        return -1;
    }
}