package 프로그래머스.카카오기출.카카오개발자겨울인턴십2019.튜플;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution("{{20,111},{111}}")));
    }

    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");

        Arrays.sort(arr, (a, b) -> {
            return a.length() - b.length();
        });

        int[] answer = new int[arr.length];

        int idx = 0;

        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if (set.add(s2)) {
                    answer[idx++] = Integer.parseInt(s2);
                }
            }
        }

        return answer;
    }
}
