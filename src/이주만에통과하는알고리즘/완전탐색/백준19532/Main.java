package 이주만에통과하는알고리즘.완전탐색.백준19532;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());
        int e = Integer.parseInt(stk.nextToken());
        int f = Integer.parseInt(stk.nextToken());

        int resX = 0;
        int resY = 0;

        boolean flag = false;
        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    resX = x;
                    resY = y;
                    flag = true;
                }
            }

            if (flag) {
                break;
            }
        }

        System.out.printf("%d %d", resX, resY);
    }
}
