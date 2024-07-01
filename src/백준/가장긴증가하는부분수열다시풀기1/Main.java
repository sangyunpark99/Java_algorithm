package 백준.가장긴증가하는부분수열다시풀기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int A;
    public static int[] array;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        array = new int[A + 1];
        int i = 1;
        while (st.hasMoreTokens()) {
            array[i++] = Integer.parseInt(st.nextToken());
        }

        dp = new int[A + 1];

        Arrays.fill(dp, 1);

        int max = 1;

        for (int j = 1; j <= A; j++) {
            for (int k = 1; k < j; k++) {
                if (array[j] > array[k]) { // 각 자리 수마다 값을 누적해준다.
                    dp[j] = Math.max(dp[j], dp[k] + 1);
                }
            }
            max = Math.max(max, dp[j]);
        }

        System.out.println(max);
    }
}
