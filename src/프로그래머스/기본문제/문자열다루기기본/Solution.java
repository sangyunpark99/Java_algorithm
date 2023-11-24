package 프로그래머스.기본문제.문자열다루기기본;

public class Solution {
    public static boolean solution(String s) {
        boolean answer = true;

        if (s.length() == 4 || s.length() == 6) {

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'
                        || s.charAt(i) >= 'a' && s.charAt(i) <= 'z') { // 알파벳이 존재하는 경우
                    answer = false;
                }
            }

        } else {
            answer = false;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("a234"));
    }
}
