package pre코딩테스트연습.two_four.two;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        new Solution().solution(new int[]{1,2,3,4,5}, 1);
    }

    public int solution(int[] A, int K) {
        int answer = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {
                String num = String.valueOf(A[i]) + String.valueOf(A[j]);
                String num2 = String.valueOf(A[j]) + String.valueOf(A[i]);
                ans.add(Integer.parseInt(num));
                ans.add(Integer.parseInt(num2));
            }
        }

        Collections.sort(ans,Collections.reverseOrder());

        return ans.get(K-1);
    }
}
