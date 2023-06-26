package pre코딩테스트연습.one_five.three;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("apple"));
    }

    public static String solution(String s){

        String answer = "";

        for (int i = s.length()-1; i >= 0 ; i--) {
            answer += s.charAt(i);
        }

        return answer;
    }
}
