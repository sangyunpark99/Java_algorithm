package 프로그래머스.구명보트;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{70,80,50},100));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        // 몸무게의 합이 limit이하면 된다.

        int l = 0;
        int r = people.length-1;

        Arrays.sort(people);

        while(l <= r){ // 투포인터 엇갈리면 끝
            int sum = people[r] + people[l];

            if(sum > limit){
                answer++;
                r--;
            }else{
                answer++;
                l++;
                r--;
            }
        }

        return answer;
    }
}
