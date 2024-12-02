package 백준.성냥개비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    // 자릿수를 크게 만들면, 제일 큰 수가 된다.

    private static int t;

    // 0 ~ 9까지 필요한 성냥개비 갯수
    private static int[] number = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

    private static String MAX_STR = "111111111111111111111111111111111111111111111111119";

    private static String[] dp;

    private static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        dp = new String[104];
        Arrays.fill(dp, MAX_STR);
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.print(findMin(n) + " ");
            System.out.print(findMax(n) + "\n");
        }
    }

    public static String findMax(int here) {
        String ret = "";
        if ((here & 1) == 1) { // 홀 수인 경우 1을 선택하고 1개를 버리는 것보다 7을 선택하는게 더 낫다
            ret += "7";
            here -= 3;
        }
        while (here != 0) {
            ret += "1";
            here -= 2;
        }

        return ret;
    }

    // dp[i] -> i 는 성냥 개비 갯수
    public static String findMin(int here) {
        dp[0] = "";

        for (int i = 2; i < 104; i++) { // n = 2 ~ 104
            for (int j = 0; j <= 9; j++) { // 0 ~ 9의 조합
                if (i - number[j] < 0) { // 성냥 개비가 부족한 경우
                    continue;
                }
                if (j == 0 && dp[i - number[j]] == "") { // 맨 앞에 0이 오는 경우 제외
                    continue;
                }
                dp[i] = getMin(dp[i], dp[i - number[j]] + j); // bottom-up 방식으로 누적
            }
        }

        return dp[here];
    }

    private static String getMin(String a, String b) {
        if (a.length() == b.length()) {
            if (a.compareTo(b) > 0) {
                return b;
            }
            return a;
        }

        if (a.length() < b.length()) {
            return a;
        }

        return b;
    }
}