package 프로그래머스.멀리뛰기;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(4));
    }

    public long solution(int n) {
        long answer = 0;

        long[] dp = new long[20001];

        dp[0] = 1L;
        dp[1] = 1L;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i-1]+dp[i-2])%1234567;
        }

        answer = dp[n];

        return answer;
    }
}
