package 프로그래머스.K번째수;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,5,2,6,3,7,4}, new int[][]{{2,5,3},{4,4,1},{1,7,3}})));
    }

    public static int[] solution(int[] array, int[][] commands){
        int[] answer = new int[3];

        for (int i = 0; i < commands.length; i++) {
            int[] sliceArray = new int[] {};

            int startIndex = commands[i][0]-1;
            int endIndex = commands[i][1];
            int kNum = commands[i][2];
            sliceArray = Arrays.copyOfRange(array,startIndex,endIndex); // 배열 자르기

            //자른 배열 정렬하기
            Arrays.sort(sliceArray);

            answer[i] = sliceArray[kNum-1];
        }
        return answer;
    }
}
