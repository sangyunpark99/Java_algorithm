package 프로그래머스.명예의전당;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,new int[]{10,100,20,150,1,100,200})));
        ;
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (list.size() <= k) {
                list.add(score[i]);
                Collections.sort(list);
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if(list.get(j) < score[i]){
                        list.remove(j);
                        list.add(j,score[i]);
                        Collections.sort(list);
                    }
                }
            }

            answer[i] = list.get(list.size()-1);
        }

        return answer;
    }
}
