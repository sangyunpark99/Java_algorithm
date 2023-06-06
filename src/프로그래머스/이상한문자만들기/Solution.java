package 프로그래머스.이상한문자만들기;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("TRy HElLo WORLD"));
    }
    
    public static String solution(String s){

        String[] words= s.split("");

        StringBuffer str = new StringBuffer();

        int index = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i] == " "){
                index = 0;
            }else if (index % 2 == 0){
                str.append(words[i].toUpperCase());
                index++;
            }else{
                str.append(words[i].toLowerCase());
                index++;
            }
        }

        return str.toString();
    }
}
