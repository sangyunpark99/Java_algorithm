package 프로그래머스.자연수뒤집어배열로만들기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        long n = 12345;
        String[] ans = String.valueOf(n).split("");
        int[] answer = new int[ans.length];

        for (int i = 0; i < ans.length ; i++) {
            answer[i] = Integer.parseInt(ans[ans.length-1-i]);
        }

        System.out.println(Arrays.toString(answer));
    }
}
