package 프로그래머스.x만큼간격이있는n개의숫자;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int x = 2;
        int n = 5;
        long[] answer = new long[n];

        answer[0] = x;
        for(int i=1; i<n; i++){
            answer[i] = answer[i-1]+x;
        }

        System.out.println(Arrays.toString(answer));
    }
}
