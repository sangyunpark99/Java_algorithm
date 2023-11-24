package 프로그래머스.기본문제.숫자문자열과영단어;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }

    public static String solution(String s) {
        String[] nums = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replace(nums[i], Integer.toString(i));
        }

        return s;
    }
}
