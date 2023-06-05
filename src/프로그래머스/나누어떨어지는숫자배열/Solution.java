package 프로그래머스.나누어떨어지는숫자배열;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{5,9,7,10},5));
    }

    public ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int item : arr){
            if(item % divisor == 0){
                answer.add(item);
            }
        }

        if(answer.size() == 0){
            answer.add(-1);
        }else{
            Collections.sort(answer);
        }

        return answer;
    }
}
