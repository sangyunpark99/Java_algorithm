package 연습문제.practice3;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        solution(new int[]{100000,99000,99000,98000, 97000});
    }

    public static int solution(int[] A) {

        int answer = 0;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length-1; i++) {
            for (int j = i+1; j < A.length; j++) {
                if(A[i]-A[j] > max){
                    max = A[j]-A[i];
                }

            }
        }

        System.out.println(max);

        return answer;
    }
}
