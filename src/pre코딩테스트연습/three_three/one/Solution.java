package pre코딩테스트연습.three_three.one;

import java.util.Arrays;

public class Solution {
    public int solution(int[] arr, int n) {
        int answer = -1;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= n) {
                answer = arr[i];
                break;
            }
        }

        return answer;
    }
}
