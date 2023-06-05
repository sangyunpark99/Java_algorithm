package 프로그래머스.정수내림차순으로배치하기;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(118372));
    }

    public long solution(long n){
        long answer = 0;

        String ans = String.valueOf(n);

        int[] list = new int[ans.length()];

        for (int i = 0; i < ans.length(); i++) {
            list[i] = ans.charAt(i) - '0'; // 문자열 int 하면 아스키코드 변환 값 나옴
        }

        Arrays.sort(list); // 크기순으로 정렬

        int[] ansList = new int[ans.length()]; // 새로 담아줄 배열 선언

        for (int i = 0; i < list.length; i++) {
            ansList[i] = list[list.length-1-i]; // 거꾸로 정렬
        }

        System.out.println(Arrays.toString(ansList));

        answer = Long.parseLong(Arrays.stream(ansList).mapToObj(String::valueOf).collect(Collectors.joining("")));

        return answer;
    }
}
