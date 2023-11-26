package 큰돌의터전알고리즘강의.three주차.이공사팔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int k = 0;
            while (stk.hasMoreTokens()) {
                map[i][k] = Integer.parseInt(stk.nextToken());
                k++;
            }
        }

        // 이동시키기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }

        System.out.println(Arrays.deepToString(map));
    }

    public void moveUp(int y, int x) {

    }

    public void moveDown(int y, int x) {

    }

    public void moveRight(int y, int x) {

    }

    public void moveLeft(int y, int x) {

    }
}
