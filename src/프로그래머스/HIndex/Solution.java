package 프로그래머스.HIndex;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{3,0,6,1,5}));
    }

    public int solution(int[] citations) {

        int answer = 0;

        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i; // 논문 갯수

            if(citations[i] >= h){
                answer = h;
                break;
            }
        }

        return answer;
    }
}
