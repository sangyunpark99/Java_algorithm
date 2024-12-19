package 프로그래머스.자물쇠와열쇠복습;

public class Solution {

    static int N, M;

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

    public static boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;

        for (int k = 0; k < 4; k++) { // 90도 회전 4번
            for (int y = -N; y < N; y++) { // 열쇠가 움직일 수 있는 최대 범위
                for (int x = -N; x < N; x++) {
                    if (solve(key, lock, y, x)) { // 각 열쇠의 좌표를 확인
                        return true;
                    }
                }
            }

            int[][] rotate = new int[M][M];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    rotate[i][j] = key[M - j - 1][i];
                }
            }

            key = rotate;
        }

        return false;
    }

    private static boolean solve(int[][] key, int[][] lock, int y, int x) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) { // key블록의 하나하나 확인
                int ny = i - y;
                int nx = j - x;
                if (ny < 0 || nx < 0 || ny >= M || nx >= M) { // 범위를 넘어가면
                    continue;
                }

                if (lock[i][j] == key[ny][nx]) { // 맞지 않는 경우
                    return false;
                }
            }
        }

        return true;
    }
}
