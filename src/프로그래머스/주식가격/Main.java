package 프로그래머스.주식가격;

public class Main {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];
            int sec = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int tmp = prices[j];

                sec++;

                if (cur > tmp) {
                    break;
                }
            }

            answer[i] = sec;
        }

        return answer;
    }
}
