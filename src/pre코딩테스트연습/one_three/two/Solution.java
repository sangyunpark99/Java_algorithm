package pre코딩테스트연습.one_three.two;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("({)}[<]>"));
    }

    public static int solution(String S) {

        Stack<String> stk = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(' || S.charAt(i) == '{' || S.charAt(i) == '{' || S.charAt(i) == '[' || S.charAt(i) == '<'){
                stk.push(String.valueOf(S.charAt(i)));
            }else{
                if(stk.size() > 0){
                    if(S.charAt(i) == ')'){
                        if(stk.peek().equals("(")){
                            stk.pop();
                        }
                    }else if(S.charAt(i) == '}'){
                        if(stk.peek().equals("{")){
                            stk.pop();
                        }
                    }else if(S.charAt(i) == ']'){
                        if(stk.peek().equals("[")){
                            stk.pop();
                        }
                    }else{
                        if(stk.peek().equals("<")){
                            stk.pop();
                        }
                    }
                }else{
                    return 0;
                }
            }
        }

        if(stk.size() > 0){
            return 0;
        }

        return 1;
    }
}
