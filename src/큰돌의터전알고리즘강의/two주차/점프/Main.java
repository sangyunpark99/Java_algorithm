package 큰돌의터전알고리즘강의.two주차.점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static long[][] map;
    public static long[][] dp;

    public static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new long[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            int j = 0;
            while(stk.hasMoreTokens()){
                map[i][j] = Integer.parseInt(stk.nextToken());
                j++;
            }
        }

        System.out.println(Arrays.deepToString(map));

        System.out.println(countPath());
    }

    public static long countPath(){
        dp[0][0] = 1;

        // 왼쪽에서 오는 경로 개수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int jump = (int) map[i][j];

                if(dp[i][j] == 0 || jump == 0){
                    continue; // 현재칸 도달 x, 종착칸
                }

                // 오른쪽 이동
                if(j + jump < n){
                    dp[i][j+jump] += dp[i][j];
                }

                // 아래로 이동
                if(i + jump < n){
                    dp[i+jump][j] += dp[i][j];
                }
            }
        }
        return dp[n-1][n-1];
    }
}
