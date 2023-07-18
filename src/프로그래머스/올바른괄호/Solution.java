package 프로그래머스.올바른괄호;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(")()("));
    }

    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            Character ch = s.charAt(i);

            if(ch=='('){ // (인경우
                stack.push(ch);
            }else if(ch == ')'){// )인경우
                if(stack.isEmpty()){
                    answer = false;
                    break;
                }else{
                    stack.pop();
                }
            }
        }

        if(stack.size() > 0){
            answer = false;
        }// 비어있지 않은 경우

        return answer; // 비어있는 경
    }
}
