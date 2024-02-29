package 백준.배열에서K번째수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1;
        long end = K;
        long ans = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) { // 각 행에서
                cnt += Math.min(middle / i, N);
            }

            if (cnt < K) {
                start = middle + 1;
            } else {
                ans = middle;
                end = middle - 1;
            }
        }

        System.out.println(ans);
    }
}
