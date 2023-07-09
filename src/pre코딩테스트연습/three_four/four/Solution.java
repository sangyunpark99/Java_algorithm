package pre코딩테스트연습.three_four.four;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,1}));
    }

    public int solution(int[] arr) {
        int answer = 0;

        int preValue = 0;
        int count = 0;

        // 1로만 이루어진 경우 -> 0이 없는 경우

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){

                if(count == 0){ // 0이면
                    count++;
                }

                if(preValue == 1){ // 이전값이 1이면 연속인 경우
                    count++;
                }

                if(i == arr.length-1){ // 마지막까지도 1이 나온다면
                    answer = Math.max(answer,count);
                }
            }else{ // 1이 아닌 수가 나온경우
                answer = Math.max(answer,count);
                count = 0; // 초기화
            }

            preValue = arr[i];
        }

        return answer;
    }
}
