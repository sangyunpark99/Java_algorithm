package 프로그래머스.기본문제.자릿수더하기;

public class Solution {

    public static void main(String[] args) {
        int n = 10;

        int answer = 0;

        String[] nums = String.valueOf(n).split("");

        for (String num : nums) {
            answer += Integer.parseInt(num);
        }

        System.out.println(answer);
    }
}
