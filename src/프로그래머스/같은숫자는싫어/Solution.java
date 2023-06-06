package 프로그래머스.같은숫자는싫어;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1,1,3,3,0,1,1}));

    }

    public static Stack solution(int[] arr){
        Stack stack = new Stack();
        stack.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if((int)stack.peek() != arr[i]){
                stack.add(arr[i]);
            }
        }

        return stack;
    }
}
