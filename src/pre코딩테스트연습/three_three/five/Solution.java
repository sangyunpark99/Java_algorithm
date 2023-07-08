package pre코딩테스트연습.three_three.five;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{-2,5,-3,6,8,-1,-5,3}));
    }

    public int solution(int[] fruits) {

        int window = 1;
        int maxValue = Integer.MIN_VALUE;

        while(window <= fruits.length){
            int sum = 0;
            for (int i = 0; i < fruits.length; i++) {

                sum += fruits[i];

                if(i >= window){
                    if(fruits[i-1] < 0){
                        sum += -1*fruits[i-window];
                    }else{
                        sum -= fruits[i-window];
                    }
                }

                maxValue = Math.max(maxValue,sum);
            }

            window++;
        }

        return maxValue;
    }
}
