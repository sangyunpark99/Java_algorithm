package 백준.쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int N;
    public static int[][] map;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        solution(0, 0, N);

        System.out.println(sb.toString());
    }

    public static void solution(int y, int x, int size) { // 시작점
        if (isPossible(y, x, size)) { // 기저사례
            sb.append(map[y][x]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');
        solution(y, x, newSize);
        solution(y, x + newSize, newSize);
        solution(y + newSize, x, newSize);
        solution(y + newSize, x + newSize, newSize);
        sb.append(')');
    }

    public static boolean isPossible(int y, int x, int size) {
        int value = map[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (value != map[i][j]) { // 다른경우 또 분할해
                    return false;
                }
            }
        }

        return true;
    }
}