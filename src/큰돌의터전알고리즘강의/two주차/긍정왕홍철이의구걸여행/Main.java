package 큰돌의터전알고리즘강의.two주차.긍정왕홍철이의구걸여행;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int[][] map;
    public static boolean[][] visited;
    public static Set<Integer> set;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{-1, 0, 1, 0};
    public static int N = 3;

    public static void main(String[] args) {
        map = new int[][]{
                {10, 20, 21},
                {70, 90, 12},
                {80, 110, 120}
        };

        visited = new boolean[3][3];
        set = new HashSet<>();
        go(0, 0, 0);
        System.out.println(set);
        System.out.println(set.size());
    }

    public static void go(int y, int x, int coin) {
        if (y == 2 && x == 2) {
            set.add(coin);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }

            visited[ny][nx] = true;
            coin += map[ny][nx];
            go(ny, nx, coin);
            visited[ny][nx] = false;
            coin -= map[ny][nx];
        }
    }
}
