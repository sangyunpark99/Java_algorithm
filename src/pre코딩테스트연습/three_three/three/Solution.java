package pre코딩테스트연습.three_three.three;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,2,3,4,5}));
    }

    public int solution(int[] A) {
        int answer = 0;

        // 정렬해서 제일 큰수, 작은수

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        Arrays.sort(A);

        for (int i = 0; i <A.length/2; i++) {
            arr1.add(A[i]);
        }

        int j = 1;
        for (int i = arr1.size()-1; i >= 0; i--) {
            answer += arr1.get(i) * (-2*j);
            j++;
        }


        for (int i = 0; i < A.length; i++) {
            if(!arr1.contains(A[i])){
                arr2.add(A[i]);
            }
        }

        for (int i = 0; i < arr2.size(); i++) {
            answer += arr2.get(i) * (2*i+1);
        }

        return answer;
    }
}
