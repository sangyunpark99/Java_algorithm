package 이주만에통과하는알고리즘.완전탐색.백준1816;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if (check(num)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean check(long number) {
        for (int i = 2; i <= 1_000_000; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
