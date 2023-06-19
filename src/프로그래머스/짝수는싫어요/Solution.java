package 프로그래머스.짝수는싫어요;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> solution  = new ArrayList<>();

        int n = 15;

        for (int i = 1; i <= n; i++) {
            if(i%2!=0){
                solution.add(i);
            }
        }

        Collections.sort(solution);

        solution.toArray(new Integer[0]);

        System.out.println(solution);
    }
}
