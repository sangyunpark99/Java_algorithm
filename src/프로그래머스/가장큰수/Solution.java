package 프로그래머스.가장큰수;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        String[] arr = new String[numbers.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 앞에서 뒤에것 빼기
        Arrays.sort(arr,(o1,o2) -> (o2 + o1).compareTo(o1 + o2));

        if("0".equals(arr[0])){
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            answer.append(arr[i]);
        }

        return answer.toString();
    }
}
