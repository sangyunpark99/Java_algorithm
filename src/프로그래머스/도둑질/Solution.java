package 프로그래머스.도둑질;

public class Solution {
    public int solution(int[] money) {
        int answer = 0;

        int[] first = new int[money.length];
        int[] second = new int[money.length];

        for (int i = 0; i < money.length; i++) {
            first[i] = money[i];
            second[i] = money[i];
        }

        // 1번집 털기
        first[1] = -1;
        first[2] += first[0];

        // 1번집 안털기
        second[0] = -1;

        // 3번째 집부터
        for (int i = 3; i < money.length; i++) {
            first[i] += Math.max(first[i - 2], first[i - 3]);
            second[i] += Math.max(second[i - 2], second[i - 3]);
        }

        // first는 처음을 포함했으므로 마지막 값 포함 x
        int max_first = Math.max(first[money.length - 2], first[money.length - 3]);

        // second는 처음을 포함하지 않으므로 마지막 값 포함 o
        int max_second = Math.max(second[money.length - 1], second[money.length - 2]);

        answer = Math.max(max_first, max_second);

        return answer;
    }
}
