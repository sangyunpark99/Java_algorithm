package 백준.서울에서경산까지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int k;

    private static Node[] walk;
    private static Node[] bicycle;

    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        walk = new Node[n];
        bicycle = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            walk[i] = new Node(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
            bicycle[i] = new Node(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
        }

        dp = new int[101][100001];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(go(0, 0));
    }

    private static int go(int idx, int time) {
        if (idx == n) { // 전부 탐색한 경우 -> 누적값 return
            return 0;
        }

        if (dp[idx][time] != -1) {
            return dp[idx][time];
        }

        int ret = Integer.MIN_VALUE;

        if (time + walk[idx].time <= k) {
            ret = Math.max(ret, go(idx + 1, time + walk[idx].time) + walk[idx].amount);
        }

        if (time + bicycle[idx].time <= k) {
            ret = Math.max(ret, go(idx + 1, time + bicycle[idx].time) + bicycle[idx].amount);
        }

        dp[idx][time] = ret; // 갱신 -> ret은 결국 최댓값

        return ret;
    }

    private static class Node {
        int time;
        int amount;

        public Node(int time, int amount) {
            this.time = time;
            this.amount = amount;
        }
    }
}