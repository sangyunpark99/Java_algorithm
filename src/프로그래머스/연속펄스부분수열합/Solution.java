package 프로그래머스.연속펄스부분수열합;

public class Solution { // 1차 40점

    private static int[] sequence;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));
    }

    public static long solution(int[] value) {
        long answer = 0;
        sequence = value;
        answer = Math.max(find(1), find(-1));

        return answer;
    }

    public static long find(int start) {
        // 1부터 시작하면, 다음껀 무조건 -1
        long maxValue = Long.MIN_VALUE;
        long curSum = 0;
        int sign = start;

        for (int value : sequence) {
            int curValue = value * sign;
            curSum = Math.max(curSum + curValue, curValue);
            maxValue = Math.max(maxValue, curSum);
            sign *= -1;
        }

        return maxValue;
    }
}
