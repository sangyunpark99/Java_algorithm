package pre코딩테스트연습.one_four.four;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("f4"));
    }

    public static String solution(String s) {
        String answer = "";

        int binaryNum = Integer.parseInt(s,16);

        answer = Integer.toBinaryString(binaryNum);

        return answer;
    }
}
