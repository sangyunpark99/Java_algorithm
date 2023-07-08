package pre코딩테스트연습.three_two.five;

import java.util.Arrays;

public class Solution {
    public int solution(int[] arr, int n) {
        int answer = -1;

        Arrays.sort(arr);

        for (int i = arr.length-1; i >= 0; i--) {
            if(n >= arr[i]){
                answer = arr[i];
                break;
            }
        }

        return answer;
    }
}
