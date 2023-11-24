package 프로그래머스.기본문제.이진변횐반복하기;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution("1111111")));
    }

    public int[] solution(String s) {
        int[] answer = new int[2];

        int changeNum = 0;
        int removeZero = 0;

        while (!s.equals("1")) {

            // 0갯수 세기
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    removeZero++;
                }
            }

            // 0제거 하기
            s = s.replaceAll("0", "");

            // 길이 추출
            int length = s.length();

            // 길이 이진법 변환
            s = Integer.toBinaryString(length);

            changeNum++; // 횟수 추가
        }

        answer[0] = changeNum;
        answer[1] = removeZero;

        return answer;
    }
}
