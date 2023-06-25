package pre코딩테스트연습.one_four.two;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"10110","1010","11110"}));
    }

    public static int solution(String[] arr) {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            answer ^= Integer.parseInt(arr[i],2);
        }

        return answer;
    }
}
