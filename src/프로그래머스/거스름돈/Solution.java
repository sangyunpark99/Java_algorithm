package 프로그래머스.거스름돈;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1, 2, 5}));
    }

    private static int[] dp;

    public static int solution(int n, int[] money) {
        int answer = 0;

        dp = new int[n + 1];

        dp[0] = 1; // 0원을 만드는 방법은

        for (int coin : money) { // coin 사용시 i원은 = coin + i - coin
            // 1원 동전으로만 만들기 -> 2원 동전 추가해서 만들기 -> 5원 동전 추가해서 만들기
            for (int i = coin; i <= n; i++) { // i원
                dp[i] = dp[i] % 1_000_000_007 + dp[i - coin] % 1_000_000_007; //
            }
        }

        answer = dp[n];

        return answer;
    }
}
