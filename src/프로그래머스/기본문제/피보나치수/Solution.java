package 프로그래머스.기본문제.피보나치수;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(99999));
    }

    public int solution(int n) {

        int answer = 0;

        int[] dp = new int[100001];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= 100_000; i++) {
            dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567;
        }

        answer = dp[n] % 1234567;

        return answer;
    }
}
