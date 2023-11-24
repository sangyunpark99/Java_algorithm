package 프로그래머스.기본문제.폰켓몬;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3}));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        int len = nums.length; // 길이

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }

        return set.size() > len / 2 ? len / 2 : set.size();
    }
}
