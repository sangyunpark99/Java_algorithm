package 프로그래머스.시저암호;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n){
        String answer = "";

        for (int i = 0; i < s.length(); i++) {

            char a = s.charAt(i);

            if(a == ' '){ // 공백인 경우 공백 추가
                answer += " ";
            }else {
                answer += shiftChar(a,n);
            }
        }

        return answer;
    }

    public static char shiftChar(char c, int n){
        if(Character.isUpperCase(c)){
            int num = c - 'A';
            num = (num + n) % 26; // 알파벳 26개의 나머지
            return (char)(num + 'A');
        }else{
            int num = c - 'a';
            num = (num + n) % 26;
            return (char)(num + 'a');
        }
    }
}
