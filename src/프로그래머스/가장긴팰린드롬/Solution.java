package 프로그래머스.가장긴팰린드롬;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("abcdcba"));
        System.out.println(solution("abacde"));
        System.out.println(solution("abcdefgaba"));
        System.out.println(solution("abcdef"));
        System.out.println(solution("aabbaa"));
        System.out.println(solution("a"));
    }

    private static boolean[][] dp;

    public static int solution(String s) {
        // bottom - up 방식으로 구현
        int answer = 0;

        dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++) { // 길이가 1인 경우
            dp[i][i] = true;
        }

        for (int i = 1; i < s.length() - 1; i++) { // 길이가 2인 경우
            if (s.charAt(i) == s.charAt(i - 1)) { // 같은 경우
                dp[i][i + 1] = true;
            }
        }

        // 길이가 3 이상인 경우
        for (int length = 3; length <= s.length(); length++) {
            for (int i = 0; i <= s.length() - length; i++) { // 시작점 지정
                int j = i + length - 1; // 끝점 지정
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (dp[i][j]) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }

        return answer;
    }
}
