package 제로베이스코딩테스트.three;

public class Solution {
    public int solution(int N) {
        int answer = 0;

        int[] dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <=10 ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        answer = dp[N];

        return answer;
    }
}
