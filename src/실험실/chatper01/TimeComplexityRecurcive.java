package 실험실.chatper01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeComplexityRecurcive {

    public static int[] a;
    public static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        a = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i - 1] = i;
        }

        int sum = go(0, N - 1);
        System.out.println(sum);
    }

    // logn?

    public static int go(int l, int r) {
        cnt++;
        if (l == r) {
            return a[l];
        }
        int mid = (l + r) / 2;
        int sum = go(l, mid) + go(mid + 1, r);
        return sum;
    }
}
