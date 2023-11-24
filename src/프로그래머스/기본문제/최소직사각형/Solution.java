package 프로그래머스.기본문제.최소직사각형;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{69}}));
    }

    public static int solution(int[][] sizes) {
        int answer = 0;

        ArrayList<Integer> maxNums = new ArrayList<>();
        ArrayList<Integer> minNums = new ArrayList<>();

        for (int i = 0; i < sizes.length; i++) {
            maxNums.add(Math.max(sizes[i][0], sizes[i][1]));
            minNums.add(Math.min(sizes[i][0], sizes[i][1]));
        }

        Collections.sort(maxNums);
        Collections.sort(minNums);

        answer = maxNums.get(maxNums.size() - 1) * minNums.get(minNums.size() - 1);

        return answer;
    }
}
