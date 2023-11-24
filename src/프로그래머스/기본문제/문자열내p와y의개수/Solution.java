package 프로그래머스.기본문제.문자열내p와y의개수;

public class Solution {
    public static void main(String[] args) {
        boolean answer = true;

        String s = "pPooyY";
        s = s.toLowerCase();

        int p_count = 0;
        int y_count = 0;

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == 'p') {
                p_count++;
            } else if (a == 'y') {
                y_count++;
            }
        }

        if (p_count == y_count) {
            answer = true;
        } else {
            answer = false;
        }

        System.out.println(answer);
    }
}
