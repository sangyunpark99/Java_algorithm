package 프로그래머스.기본문제.문자열을정수로바꾸기;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("-1234"));
    }

    public int solution(String s) {
        int answer = 0;

        answer = Integer.parseInt(s);

        return answer;
    }
}
