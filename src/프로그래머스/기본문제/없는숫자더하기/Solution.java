package 프로그래머스.기본문제.없는숫자더하기;

public class Solution {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};

        int answer = solution(numbers);
        System.out.println(answer);
    }

    public static int solution(int[] numbers) {
        int answer = -1;

        int[] result = new int[10];

        for (int num : numbers) {
            result[num]++; // 존재하는 값 플러스
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i] < 1) {
                answer += i;
            }
        }

        return answer;
    }
}
