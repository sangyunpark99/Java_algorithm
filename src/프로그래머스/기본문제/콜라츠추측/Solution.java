package 프로그래머스.기본문제.콜라츠추측;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(626331));
    }

    public static int solution(int num) {
        int answer = 0;

        int count = 0;

        while (num != 1 && count < 500) {

            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 2 == 1) {
                num = 3 * num + 1;
            }

            count++;
        }

        if (count == 500) {
            answer = -1;
        } else {
            answer = count;
        }

        return answer;
    }
}
