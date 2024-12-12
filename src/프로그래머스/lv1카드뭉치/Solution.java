package 프로그래머스.lv1카드뭉치;

public class Solution {

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int cards1Idx = 0;
        int cards2Idx = 0;

        for (String word : goal) {
            if (cards1Idx < cards1.length && cards1[cards1Idx].equals(word)) {
                cards1Idx++;
                continue;
            } else if (cards2Idx < cards2.length && cards2[cards2Idx].equals(word)) {
                cards2Idx++;
                continue;
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{
                "i", "water", "drink"
        }, new String[]{
                "want", "to"
        }, new String[]{
                "i", "want", "to", "drink", "water"
        }));
    }
}
