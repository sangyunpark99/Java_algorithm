package 프로그래머스.JadenCase문자열만들기;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("3people unFollowed me"));
    }

    public String solution(String s) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {

            int flag = 0;
            char ch = s.charAt(i);

            if(i == 0){ // 맨 처음 글자
                if(!Character.isDigit(ch)){ // 대문자로
                    answer += String.valueOf(ch).toUpperCase();
                    flag = 1;
                }
            }else{ // 첫번째 다음 글자
                if(s.charAt(i-1) == ' '){
                    answer += String.valueOf(ch).toUpperCase();
                    flag = 1;
                }
            }

            if(flag == 0){
                answer += String.valueOf(ch).toLowerCase();
            }
        }

        return answer;
    }
}
