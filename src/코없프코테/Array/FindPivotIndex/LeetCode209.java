package 코없프코테.Array.FindPivotIndex;

import java.util.Arrays;

public class LeetCode209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public static int minSubArrayLen(int target, int[] nums){

        // 길이가 가변 : 투포인터 알고리즘
        int subArraySum = 0;
        int minSize = Integer.MAX_VALUE;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            subArraySum += nums[i];

            while(subArraySum >= target){
                if(subArraySum == target){ // target과 같은 값인 경우
                    minSize = Math.min(minSize, i - k + 1); // 길이 갱신
                }
                // 그렇지 않은 경우, 맨 앞의 원소를 빼준다.
                subArraySum -= nums[k]; // 맨 처음 원소를 제거
                k++;
            }
        }

        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}