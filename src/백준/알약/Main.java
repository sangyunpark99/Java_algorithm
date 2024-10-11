package 백준.알약;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static long[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // dp[i][j]=i개의 완전한 알략, j개의 반쪽짜리 약이 남았을 때 조합의 수

        dp = new long[31][31]; // 한쪽 or 반쪽

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }

            sb.append(go(num, 0) + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static Long go(int whole, int notWhole) {

        if (whole == 0 && notWhole == 0) { // 알약이 남아있지 않은 경우
            return 1L;
        }

        if (dp[whole][notWhole] > 0) {
            return dp[whole][notWhole];
        }

        long ret = dp[whole][notWhole]; // 이전 값

        // 알약이 존재하고, 전체 알약을 꺼낸 경우
        if (whole > 0) { // 첫째날 약 하나를 꺼내므로 먼저 시작
            ret += go(whole - 1, notWhole + 1);
        }

        // 반쪽자리 알약이 존재하고, 반개짜리 알약을 꺼낸 경우
        if (notWhole > 0) {
            ret += go(whole, notWhole - 1);
        }

        dp[whole][notWhole] = ret; // dp 값 누적

        return ret;
    }
}