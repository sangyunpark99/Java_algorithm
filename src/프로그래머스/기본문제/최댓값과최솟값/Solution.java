package 프로그래머스.기본문제.최댓값과최솟값;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("1 2 3 4"));
    }

    public String solution(String s) {
        String answer = "";

        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        answer += arr[0];
        answer += " ";
        answer += arr[arr.length - 1];

        return answer;
    }
}
