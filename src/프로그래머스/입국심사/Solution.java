package 프로그래머스.입국심사;

public class Solution {

    private static int[] times;
    private static int human;

    public static void main(String[] args) {
        System.out.println(solution(1_000_000_000, new int[]{1, 2}));
        System.out.println(solution(1, new int[]{7, 10}));
        System.out.println(solution(2, new int[]{7, 10}));
    }

    public static long solution(int n, int[] value) {
        long answer = 0;
        times = value;

        human = n;
        answer = binarySearch();

        return answer;
    }

    private static long binarySearch() {
        long totalTime = 0;

        long start = 1;
        long end = 1_000_000_000L * 100_000L; // 끝나는 시간 최대 범위
        long middle = 0;

        while (start <= end) {
            middle = (start + end) / 2;

            if (check(middle)) { // 범위를 더 줄여
                totalTime = middle;
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return totalTime;
    }

    private static boolean check(long curTime) { // true인 경우 범위 감소
        int sum = 0;
        for (int time : times) {
            sum += curTime / time;
        }

        if (sum < human) { // 주어진 인원수를 충족하지 못하는 경우
            return false;
        }

        return true; // 주어진 인원수를 충족하는 경우
    }
}
