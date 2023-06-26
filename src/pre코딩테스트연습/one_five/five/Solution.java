package pre코딩테스트연습.one_five.five;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("Naver"));
    }

    public static String solution(String s){
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            if(Character.isUpperCase(s.charAt(i))){
                answer += Character.toLowerCase(s.charAt(i));
            }else{
                answer += Character.toUpperCase(s.charAt(i));
            }
        }

        return answer;
    }
}
