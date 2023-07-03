package pre코딩테스트연습.two_five.two;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,3,5,3,2},3));
    }

    public int solution(int[] nums, int n) {
        int answer = -1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == n){
                answer = i;
                break;
            }
        }

        return answer;
    }
}
