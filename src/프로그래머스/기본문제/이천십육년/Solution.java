package 프로그래머스.기본문제.이천십육년;

import java.time.LocalDate;

public class Solution {

    public static String[] DAYS = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b) {
        String answer = "";

        answer = LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0, 3);

        return answer;
    }
}
