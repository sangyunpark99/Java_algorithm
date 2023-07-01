package pre코딩테스트연습.two_four.four;

public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().solution(new int[]{2,5,6,3,2,6,6}));
    }

    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    answer++;
                }
            }
        }

        return answer;
    }
}
