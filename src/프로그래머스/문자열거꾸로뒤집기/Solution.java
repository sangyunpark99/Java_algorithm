package 프로그래머스.문자열거꾸로뒤집기;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("jaron"));
    }

    public static String solution(String my_string){
        String answer = "";

        for(int i=my_string.length()-1; i>=0 ; i--){
            answer += my_string.charAt(i);
        }

        return answer;
    }
}
