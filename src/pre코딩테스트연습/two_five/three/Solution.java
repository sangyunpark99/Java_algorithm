package pre코딩테스트연습.two_five.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{4,8,6,1,2}));
    }

    public int solution(int[] cards) {

        Arrays.sort(cards);

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = cards.length-1; i >= 0; i--) {
            answer.add(cards[i]);
        }

        while(answer.size() > 1){
            int first = answer.remove(0);
            int second = answer.remove(0);

            if(first != second){
                int gap = first - second;
                answer.add(gap);
                Collections.sort(answer,Collections.reverseOrder());
            }

        }

        return answer.size()>0?answer.get(0):0;
    }
}
