package 프로그래머스.카카오기출.카카오개발자겨울인턴십2019.징검다리건너기;

// 찾고자 하는 값에 대해서 이분 탐색

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    public int solution(int[] stones, int k) {
        int answer = 0;

        int[] copy = Arrays.copyOf(stones, stones.length);

        Arrays.sort(copy);

        int low = 1;
        int high = copy[copy.length - 1];

        while (low <= high) {
            int mid = (low + high) / 2; // 인원수
            if (isPossible(stones, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        answer = low;

        return answer;
    }

    public boolean isPossible(int[] stones, int k, int mid) {
        int count = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] - mid <= 0) {
                count++;
            } else {
                count = 0;
            }

            if (count >= k) {
                return false;
            }
        }

        return true;
    }
}
