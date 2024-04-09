package 백준.일곱난쟁이재귀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] a;
    public static int sum;
    public static int firstIdx;
    public static int secondIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = new int[9];

        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }

        Arrays.sort(a);

        solve(0, 1);

        for (int i = 0; i < 9; i++) {
            if (i == firstIdx || i == secondIdx) {
                continue;
            }
            System.out.println(a[i]);
        }
    }

    public static void solve(int firstIdx, int secondIdx) {
        if (sum - (a[firstIdx] + a[secondIdx]) == 100) {
            return;
        }

        if (sum - (a[firstIdx] + a[secondIdx]) > 100) {
            solve(firstIdx, secondIdx--);
        } else {
            solve(firstIdx++, secondIdx);
        }
    }
}
