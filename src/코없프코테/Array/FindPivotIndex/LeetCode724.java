package 코없프코테.Array.FindPivotIndex;

import java.util.Arrays;

public class LeetCode724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
    }

    public static int pivotIndex(int[] nums){

        int pastPivotNum = 0;
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum(); // 배열 합계 구하기

        for (int i = 0; i < nums.length; i++) { // 총 n번 돌아야 함

            int num = nums[i];

            rightSum -= num;
            leftSum += pastPivotNum;

            if(leftSum == rightSum){
                return i;
            }

            pastPivotNum = num; // 이전 값
        }

        // pivot 을 찾지 못한 경우도 생각해주어야 한다.
        return -1;
    }
}
