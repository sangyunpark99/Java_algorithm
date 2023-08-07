package 프로그래머스.괄호회전하기;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("}}}"));
    }

    public int solution(String s){
        int answer = 0;

        // 맨 처음 돌릴때
        if(getRight(s)){
            answer += 1;
        }

        for (int i = 1; i < s.length(); i++) {
            StringBuffer sb = new StringBuffer(s);
            sb.append(sb.charAt(0));
            sb.delete(0,1);
            s = sb.toString();
            if(getRight(s)){
                answer++;
            }
        }

        return answer;
    }

    public boolean getRight(String s){

        boolean answer = false;

        Stack stack = new Stack();

        for (int i = 0; i < s.length(); i++) {

            char item = s.charAt(i);

            if(stack.size() == 0){

                if(item == ')' || item == '}' || item == ']'){
                    return answer;
                }else{
                    stack.add(item);
                }
            }else{
                if(item == '(' || item == '{' || item == '['){ // 값 넣기
                    stack.add(item);
                }else{
                    if(item == ')'){ // 값 빼기
                        if(stack.peek().equals('(')){
                            stack.pop();
                        }else{
                            stack.add(item);
                        }
                    }else if(item == '}'){
                        if(stack.peek().equals('{')){
                            stack.pop();
                        }else{
                            stack.add(item);
                        }
                    }else{
                        if(stack.peek().equals('[')){
                            stack.pop();
                        }else{
                            stack.add(item);
                        }
                    }
                }
            }
        }

        if(stack.size()==0){
            answer = true;
        }

        return answer;
    }
}
