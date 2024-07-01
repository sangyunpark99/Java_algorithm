package 백준.가장긴증가하부분수열4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int n = 0;
    public static int[] prev;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[n];
        prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int ret = 0;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }

            if (ret < dp[i]) { // 최댓값
                ret = dp[i];
                idx = i; // 마지막 인덱스 값
            }
        }

        System.out.println(ret);

        go(idx);
    }

    public static void go(int idx) {
        if (idx == -1) {
            return;
        }
        go(prev[idx]);
        System.out.print(arr[idx] + " ");
    }
}
