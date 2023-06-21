package 연습문제.practice4;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static boolean solution(int num) {
        boolean answer = false;

        int[] amount = new int[]{1,2,3};

        num -= 1; // 1을 뺀수를 만들 수 있다?

        System.out.println(plus(num,amount));

        if(plus(num,amount)){
            answer = false;
        }else{
            answer =true;
        }

        return answer;
    }

    public static boolean plus(int num, int[] amount){
        if(num == 0){
            return true;
        }

        if(num<0){
            return false;
        }

        for(int a : amount){
            int re = num - a;
            if(plus(re,amount)){
                return true;
            }
        }

        return false;
    }
}
