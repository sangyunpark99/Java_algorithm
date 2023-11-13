package 이주만에통과하는알고리즘.완전탐색.백준14568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int res = 0;

        for (int i = 1; i <= n; i++) {
            int A = i;
            for (int j = 1; j <= n - i; j++) {
                int B = j;
                int C = n - A - B;
                if (check(A, B, C)) {
                    res++;
                }
            }
        }

        System.out.println(res);
    }

    private static boolean check(int A, int B, int C) {
        if (!(A > 0 && B > 0 && C > 0)) {
            return false;
        }
        if (!(C >= B + 2)) {
            return false;
        }
        if (A + B + C != n) {
            return false;
        }
        if (A % 2 == 1) {
            return false;
        }

        return true;
    }
}
