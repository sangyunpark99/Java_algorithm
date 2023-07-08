package pre코딩테스트연습.three_one.one;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,2,2,3,3,3,4,4,4,4}));
    }

    public boolean solution(int[] arr) {
        boolean answer = true;
        
        int[] ans = new int[21]; // 카운팅 배열

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            ans[arr[i]]++;
            maxValue = Math.max(maxValue,arr[i]);
        }

        int[] setArr = Arrays.stream(arr).distinct().toArray();

        for (int i = 0; i < setArr.length; i++) {
            for (int j = i+1; j < setArr.length; j++) {
                if(ans[setArr[i]] == ans[setArr[j]]){
                    return false;
                }
            }
        }
        
        return answer;
    }
}
