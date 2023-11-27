package 큰돌의터전알고리즘강의.three주차.이공사팔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] map;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{-1, 0, 1, 0};
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int y = 0; y < n; y++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(stk.nextToken());
            }
        }

        permutation(new int[5], 0);
        System.out.println(max);
    }

    // 어디로 이동시켜야 할지 조합을 찾아야 한다. - 중복 조합
    public static void permutation(int[] arr, int depth) {
        if (depth == 5) {

            // 5개의 조합을 찾은경우, 화면을 이동시킨다.
            int[][] mapCopy = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mapCopy[i][j] = map[i][j];
                }
            }

            for (int i = 0; i < 5; i++) { // 찾은 조합으로 이동시키기
                int dir = arr[i]; // 방향

                if (dir == 0) {
                    // 위로 이동
                    up(mapCopy);
                } else if (dir == 1) {
                    // 오른쪽 이동
                    right(mapCopy);
                } else if (dir == 2) {
                    // 아래 이동
                    down(mapCopy);
                } else if (dir == 3) {
                    // 왼쪽 이동
                    left(mapCopy);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (max < mapCopy[i][j]) {
                        max = Math.max(max, mapCopy[i][j]);
                    }
                }
            }

            return;
        }

        for (int i = 0; i < 4; i++) { // 중복조합
            arr[depth] = i;
            permutation(arr, depth + 1);
        }
    }

    public static void up(int[][] map) { // 위로 이동
        for (int i = 0; i < n; i++) {
            int index = 0;
            int block = 0;
            for (int j = 0; j < n; j++) {
                if (map[j][i] != 0) {
                    if (block == map[j][i]) {
                        map[index - 1][i] = block * 2;
                        block = 0;
                        map[j][i] = 0;
                    } else {
                        block = map[j][i];
                        map[j][i] = 0;
                        map[index][i] = block;
                        index++;
                    }
                }
            }
        }
    }

    public static void down(int[][] map) {
        for (int i = 0; i < n; i++) {
            int index = n - 1;
            int block = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    if (block == map[j][i]) {
                        map[index + 1][i] = block * 2;
                        block = 0;
                        map[j][i] = 0;
                    } else {
                        block = map[j][i];
                        map[j][i] = 0;
                        map[index][i] = block;
                        index--;
                    }
                }
            }
        }
    }

    public static void left(int[][] map) {
        for (int i = 0; i < n; i++) {
            int index = 0;
            int block = 0;
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    if (block == map[i][j]) {
                        map[i][index - 1] = block * 2;
                        block = 0;
                        map[i][j] = 0;
                    } else {
                        block = map[i][j];
                        map[i][j] = 0;
                        map[i][index] = block;
                        index++;
                    }
                }
            }
        }
    }

    public static void right(int[][] map) {
        for (int i = 0; i < n; i++) {
            int index = n - 1;
            int block = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] != 0) {
                    if (block == map[i][j]) {
                        map[i][index + 1] = block * 2;
                        block = 0;
                        map[i][j] = 0;
                    } else {
                        block = map[i][j];
                        map[i][j] = 0;
                        map[i][index] = block;
                        index--;
                    }
                }
            }
        }
    }
}
