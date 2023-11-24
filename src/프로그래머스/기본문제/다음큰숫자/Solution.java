package 프로그래머스.기본문제.다음큰숫자;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(78));
    }

    public int solution(int n) {
        int answer = 0;

        String nBinary = Integer.toBinaryString(n);
        int oneNum = 0;
        for (int i = 0; i < nBinary.length(); i++) {
            if (nBinary.charAt(i) == '1') {
                oneNum = getOneNum(nBinary);
            }
        }

        for (int i = n + 1; i <= 1_000_000; i++) {
            String iBinary = Integer.toBinaryString(i);
            int oneKNum = getOneNum(iBinary);
            if (oneKNum == oneNum) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public int getOneNum(String binary) {
        int num = 0;
        for (int k = 0; k < binary.length(); k++) {
            if (binary.charAt(k) == '1') {
                num++;
            }
        }

        return num;
    }
}
