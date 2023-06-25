package pre코딩테스트연습.one_three.one;

import java.util.LinkedHashMap;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("aacddefg"));
    }

    public static String solution(String s) {

        Stack<String> stk = new Stack<>();
        String answer = "";

        for (int i = 0; i < s.length(); i++) {

            if(stk.size() > 0){
                if(stk.peek().equals(String.valueOf(s.charAt(i)))){
                    stk.pop();
                    continue;
                }
            }

            stk.push(String.valueOf(s.charAt(i)));
        }

        for (int i = 0; i < stk.size(); i++) {
            answer += stk.get(i);
        }

        return answer;
    }
}
