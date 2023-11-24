package 프로그래머스.기본문제.영어끝말잇기;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(3,
                new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
    }

    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (list.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }

            list.add(words[i]);

            if (i > 0 && words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }

        return answer;
    }
}
