package pre코딩테스트연습.two_one.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

class Solution {

    public int[] solution(int[] arr1, int[] arr2) {
        int[] answer = new int[101];

        arr1 = IntStream.of(arr1).distinct().toArray();
        arr2 = IntStream.of(arr2).distinct().toArray();

        Arrays.fill(answer, 0);

        for (int i = 0; i < arr1.length; i++) {
            if(answer[arr1[i]] < 2){
                answer[arr1[i]]++;
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if(answer[arr2[i]] < 2){
                answer[arr2[i]]++;
            }
        }

        ArrayList<Integer> sol = new ArrayList<>();

        for (int i = 0; i < answer.length; i++) {
            if(answer[i] == 2){
                sol.add(i);
            }
        }


        return sol.stream().mapToInt(Integer::intValue).toArray();
    }
}