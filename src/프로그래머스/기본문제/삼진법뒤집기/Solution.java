package 프로그래머스.기본문제.삼진법뒤집기;

public class Solution {
    public static int solution(int n) {
        int answer = 0;

        String threeNum = convertToBase3(n); // reverse된 값이 들어
        answer = convertToBase10(threeNum);

        return answer;
    }

    public static String convertToBase3(int num) {

        StringBuffer base3 = new StringBuffer();
        while (num > 0) {
            base3.append(num % 3);
            num /= 3;
        }

        return base3.toString();
    }

    public static int convertToBase10(String num) {

        int answer = 0;

        for (int i = 0; i < num.length(); i++) {
            answer += (num.charAt(num.length() - 1 - i) - '0') * Math.pow(3, i);
        }

        return answer;

    }

    public static void main(String[] args) {
        System.out.println(solution(125));
    }
}
