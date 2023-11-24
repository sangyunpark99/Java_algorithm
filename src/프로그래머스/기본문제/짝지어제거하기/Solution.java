package 프로그래머스.기본문제.짝지어제거하기;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("cdcddcdc"));
    }

    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char item = s.charAt(i);

            if (stack.isEmpty()) {
                stack.add(item);
            } else {
                if (stack.peek() == item) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}
