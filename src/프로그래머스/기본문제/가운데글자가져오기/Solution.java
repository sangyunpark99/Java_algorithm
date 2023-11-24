package 프로그래머스.기본문제.가운데글자가져오기;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("qwer"));
    }

    public String solution(String s) {
        String answer = "";

        if (s.length() % 2 == 0) { // 갯수가 짝수인경우
            answer += String.valueOf(s.charAt(s.length() / 2 - 1)) + String.valueOf(s.charAt(s.length() / 2));
        } else {
            answer += s.charAt((int) s.length() / 2);
        }

        return answer;
    }
}
