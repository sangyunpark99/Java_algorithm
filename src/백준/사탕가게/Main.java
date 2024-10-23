package 백준.사탕가게;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;

    public static long[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 8을 만드는 경우의 수
        while (true) {

            StringTokenizer stk = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stk.nextToken());
            m = (int) (Double.parseDouble(stk.nextToken()) * 100 + 0.5);

            if (n == 0) {
                break;
            }

            dp = new long[10001]; // 가격이 가질 수 있는 최대 칼로리 값

            ArrayList<Candy> candies = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(br.readLine());
                int cal = Integer.parseInt(stk.nextToken());
                int money = (int) (Double.parseDouble(stk.nextToken()) * 100 + 0.5);
                candies.add(new Candy(cal, money));
            }

            for (int i = 0; i < candies.size(); i++) {
                int money = candies.get(i).price;
                for (int j = money; j <= m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - money] + candies.get(i).cal); // 최댓값 찾기
                }
            }

            System.out.println(dp[m]);
        }
    }

    public static class Candy {
        int cal;
        int price;

        public Candy(int cal, int price) {
            this.cal = cal;
            this.price = price;
        }
    }
}