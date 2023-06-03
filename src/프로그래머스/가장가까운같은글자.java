package 프로그래머스;

import java.util.Arrays;

public class 가장가까운같은글자 {
    public static void main(String[] args) {
        solution("foobar");
    }

    public static int solution(String s){

        int[] answer = new int[s.length()];
        Arrays.fill(answer,-1);

        for(int i = 0; i < s.length(); i++){ // 가장 가까운 것은 고려해줄 필요가 없다.

            for(int j = 0; j < i; j++){
                if(s.charAt(i) == s.charAt(j)){
                    answer[i] = i-j;
                }
            }
        }

        return 0;
    }
}
