package 프로그래머스.기본문제.하샤드수;

public class Solution {

    public static void main(String[] args) {
        solution(10);
    }

    public static boolean solution(int x) {
        boolean answer = true;

        String[] numbers = String.valueOf(x).split(""); // 배열로 만들기

        int sumNumbers = 0;

        for (String number : numbers) { // O(n)
            sumNumbers += Integer.parseInt(number); // 각 자릿수 합
        }

        if (x % sumNumbers != 0) { // 나누어떨어지지 않는 경우
            answer = false;
        }

        return answer;
    }
}
