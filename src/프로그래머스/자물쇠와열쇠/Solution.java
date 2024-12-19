package 프로그래머스.자물쇠와열쇠;

import java.util.ArrayList;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{
                        {0, 0, 0},
                        {1, 0, 0},
                        {0, 1, 1}
                },
                new int[][]{
                        {1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}
                }
        ));
    }

    static int m, n;
    static int[][] key;
    static int[][] lock;
    static int count;

    public static boolean solution(int[][] value1, int[][] value2) {
        m = value1.length;
        n = value2.length;

        key = value1;
        lock = value2;

        // 빈칸 개수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lock[i][j] == 0) {
                    count++;
                }
            }
        }

        if (count == 0) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            if (i != 0) {
                key = rotate(key);
            }
            if (check(key)) {
                return true;
            }
        }

        return false;
    }

    public static int[][] rotate(int[][] cur) {
        int[][] temp = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) { // 시계 방향 회전
                temp[i][j] = cur[m - 1 - j][i];
            }
        }
        return temp;
    }

    public static boolean validation(int nx, int ny) {
        if (0 <= nx && 0 <= ny && nx < n && ny < n) {
            return true;
        }
        return false;
    }

    public static boolean check(int[][] input) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (lock[i][j] == 1) {
                    continue;
                }
                for (int[] target : list) { // 기준
                    int x = target[0];
                    int y = target[1];
                    int sum = 1;
                    boolean flag = true;
                    for (int[] same : list) {
                        int next_x = same[0] - x;
                        int next_y = same[1] - y;
                        if (next_x == 0 && next_y == 0) {
                            continue;
                        }
                        int check_x = i + next_x;
                        int check_y = j + next_y;
                        if (!validation(check_x, check_y)) {
                            continue;
                        }
                        if (lock[check_x][check_y] == 1) {
                            flag = false;
                            break;
                        } else {
                            sum++;
                        }
                    }
                    if (flag && sum == count) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}