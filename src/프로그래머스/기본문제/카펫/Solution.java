package 프로그래머스.기본문제.카펫;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(10, 2)));
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int num = brown + yellow;

        // 약수 찾기
        // 가로 > 세로
        //(1,12), (2,6), (3,4), (4,3)
        for (int i = 3; i < num; i++) { // 최소 3부터 시작
            int j = num / i; // j

            if (num % j == 0 && num % i == 0) { // 둘다 나눠떨어지는
                int row = Math.max(i, j); // 가로 값이 더 커야함
                int col = Math.min(i, j); // 세로 값이 더 작아야함

                if ((row - 2) * (col - 2) == yellow) { // yellow 갯수와 같은 경우
                    answer[0] = row;
                    answer[1] = col;
                }
            }
        }

        return answer;
    }
}
