package 큰돌의터전알고리즘강의.two주차.이차원배열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {

            stk = new StringTokenizer(br.readLine());

            int j = 0;
            while(stk.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(stk.nextToken());
                j++;
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            int answer = 0;

            stk = new StringTokenizer(br.readLine());

            int startY = Integer.parseInt(stk.nextToken()) - 1; // 끝지점 - 1
            int startX = Integer.parseInt(stk.nextToken()) - 1; // 끝지점 - 1
            int endY = Integer.parseInt(stk.nextToken());
            int endX = Integer.parseInt(stk.nextToken());

            for (int j = startY; j < endY; j++) {
                for (int l = startX; l < endX; l++) {
                    answer += arr[j][l];
                }
            }

            System.out.println(answer);
        }
    }
}
