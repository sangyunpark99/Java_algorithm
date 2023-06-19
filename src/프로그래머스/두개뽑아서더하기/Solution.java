package 프로그래머스.두개뽑아서더하기;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2,1,3,4,1})));
    }

    public static int[] solution(int[] numbers){ // 중복제거 Set
        int[] answer = {};

        TreeSet<Integer> list = new TreeSet<>(); // 중복 제거 + 순서 정렬

        // 배열은 length
        for (int i = 0; i < numbers.length-1; i++) { // 길이 전까지
            for (int j = i+1; j < numbers.length; j++) { // 길이 끝까지
                list.add(numbers[i] + numbers[j]); // 중복제거됨
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
