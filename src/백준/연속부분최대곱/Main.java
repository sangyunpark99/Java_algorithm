package 백준.연속부분최대곱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        double[] arr = new double[n + 1];
        double[] dp = new double[n + 1];

        double max = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
            dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]); // dp 사용
            max = Math.max(max, dp[i]);
        }

        System.out.print(String.format("%.3f", max));
    }
}