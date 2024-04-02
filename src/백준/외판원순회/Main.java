package 백준.외판원순회;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static int N;
    public static final int INF = 17_000_000;
    public static int[][] W, dp;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        dp = new int[N][(1 << N) - 1];

        for (int i = 0; i < N; i++) {
            W[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(tspAlgorithm(0, 1) + "\n");
        bw.flush();
        br.close();
    }

    public static int tspAlgorithm(int now, int visited) {
        if (visited == (1 << N) - 1) {
            if (W[now][0] == 0) {
                return INF;
            }

            return W[now][0];
        }

        if (dp[now][visited] != -1) {
            return dp[now][visited];
        }

        dp[now][visited] = INF;

        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) == 0 && W[now][i] != 0) {
                dp[now][visited] = Math.min(dp[now][visited], tspAlgorithm(i, visited | (1 << i)) + W[now][i]);
            }
        }

        return dp[now][visited]; // 최종결과
    }
}