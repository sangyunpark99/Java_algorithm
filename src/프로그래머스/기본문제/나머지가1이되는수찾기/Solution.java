package 프로그래머스.기본문제.나머지가1이되는수찾기;

public class Solution {

    public int solution(int n) {
        int answer = 0;
        answer = findNum(n);
        return answer;
    }

    public static int findNum(int n) {

        int result = 0;

        for (int i = n; i > 0; i--) {
            if (n % i == 0) {
                result = i;
            }
        }
        return result;
    }
}
