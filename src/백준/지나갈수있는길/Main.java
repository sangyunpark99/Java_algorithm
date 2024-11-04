package 백준.지나갈수있는길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int L;

    public static int[][] map;

    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            if (checkRow(i)) {
                result++;
            }

            if (checkCol(i)) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static boolean checkRow(int row) {
        boolean[] isStair = new boolean[N]; // 경사로 설치 여부

        for (int i = 0; i < N - 1; i++) {
            int gap = map[row][i] - map[row][i + 1];
            if (gap > 1 || gap < -1) {
                return false;
            } else if (gap == -1) { // 다음이 더 높은 경우
                for (int j = 0; j < L; j++) { // 올라가는 경사로 설치 확인
                    if (i - j < 0 || isStair[i - j]) {
                        return false;
                    }
                    if (map[row][i] != map[row][i - j]) {
                        return false;
                    }
                    isStair[i - j] = true;
                }
            } else if (gap == 1) { // 내려가는 경사면
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || isStair[i + j]) {
                        return false;
                    }
                    if (map[row][i] - 1 != map[row][i + j]) {
                        return false;
                    }
                    isStair[i + j] = true;
                }
            }
        }

        return true;
    }

    private static boolean checkCol(int col) {
        boolean[] isStair = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int gap = map[i][col] - map[i + 1][col];
            if (gap > 1 || gap < -1) {
                return false;
            } else if (gap == -1) { // 올라가는 경사면
                for (int j = 0; j < L; j++) {
                    if (i - j < 0 || isStair[i - j]) {
                        return false;
                    }

                    if (map[i][col] != map[i - j][col]) {
                        return false;
                    }

                    isStair[i - j] = true;
                }
            } else if (gap == 1) {
                for (int j = 1; j <= L; j++) { // 내려가는 경사면
                    if (i + j >= N || isStair[i + j]) {
                        return false;
                    }

                    if (map[i][col] - 1 != map[i + j][col]) {
                        return false;
                    }

                    isStair[i + j] = true;
                }
            }
        }

        return true;
    }
}
