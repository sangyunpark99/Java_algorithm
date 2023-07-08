package pre코딩테스트연습.three_two.two;

import java.util.ArrayList;
import java.util.Arrays;

// 조ㅏ
public class Solution {

    public static void main(String[] args) {
        new Solution().solution(new int[]{1,3,6,9,12},new int[]{2,4,6,8,10,12});
    }

    public int[] solution(int[] arr1, int[] arr2) {
        int[] answer = new int[100];

        for (int i = 0; i < arr1.length; i++) {
            answer[arr1[i]]++;
        }

        for (int i = 0; i < arr1.length; i++) {
            answer[arr2[i]]++;
        }

        System.out.println(Arrays.toString(answer));

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 2) {
                ans.add(i);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
