package 코없프코테.Array.MoveToZeros;

import java.util.Arrays;

public class LeetCode283 {

    public static void main(String[] args) {
        moveZeroes(new int[]{1,2,3,4,0,0});
    }

    public static void moveZeroes(int[] nums) {
        int p1 = 0; // 0을 가리킨다.
        int p2 = 0; // 숫자를 가리킨다.

        for (p2 = 0; p2 < nums.length; p2++) {

            if(nums[p2]!=0){ // 숫자를 만난 경우
                // 값 변경
                swap(nums, p1, p2);

                p1++; // p1 인덱스 늘려주기
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums,int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
