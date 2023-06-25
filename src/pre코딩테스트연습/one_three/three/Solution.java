package pre코딩테스트연습.one_three.three;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("AB"));
    }

    public static int solution(String S) {
        int answer = 0;

        Stack<String> stk = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if(stk.size()>0){
                if(stk.peek().equals(String.valueOf(S.charAt(i)))){
                    stk.pop();
                    continue;
                }
            }

            stk.push(String.valueOf(S.charAt(i)));
        }

        return stk.size()==0?1:0;
    }
}
