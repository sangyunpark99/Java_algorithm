package 프로그래머스.연속부분수열합의개수;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{7,9,1,1,4}));
    }

    public int solution(int[] elements) {
        int answer = 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= elements.length; i++) {
            getSum(i,set,elements);
        }

        answer = set.size();

        return answer;
    }

    public void getSum(int i, Set<Integer> set, int[] elements){

        // i개씩 묶기
        int[] newElements = new int[elements.length*2];

        // 배열합치기
        System.arraycopy(elements,0,newElements,0,elements.length);
        System.arraycopy(elements,0,newElements,elements.length,elements.length);

        for (int j = 0; j < elements.length; j++) {
            int sum = 0;
            for (int k = j; k < j+i; k++) {
                sum += newElements[k];
            }
            set.add(sum);
        }
    }
}
