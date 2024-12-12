package 프로그래머스.lv2택배상자;

import java.util.Stack;

public class Solution {

    public static int solution(int[] order) {
        int answer = 1;

        Stack<Integer> stack = new Stack<>();
        int idx = 0; // order

        for (int box = 1; box <= order.length; box++) { // 상자를 기준으로 생각
            if (box == order[idx]) {
                idx++;
            } else {
                stack.push(box);
            }

            while (!stack.isEmpty() && stack.peek() == order[idx]) { // 올바른 택배 상자가 나올때까지 순회
                stack.pop();
                idx++;
            }
        }

        answer = idx;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 5, 3, 2, 1}));
    }
}