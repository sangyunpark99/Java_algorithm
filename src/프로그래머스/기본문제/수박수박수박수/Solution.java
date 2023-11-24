package 프로그래머스.기본문제.수박수박수박수;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(4));
    }

    public String solution(int n) {
        String answer = "";

        for (int i = 0; i < n / 2; i++) {
            answer += "수박";
        }

        if (n % 2 == 1) {
            answer += "수";
        }

        return answer;
    }
}
