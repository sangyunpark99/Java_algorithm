package 프로그래머스.기본문제.핸드폰번호가리기;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
    }

    public static String solution(String phone_number) {
        StringBuffer answer = new StringBuffer();

        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer.append('*');
        }

        answer.append(phone_number.substring(phone_number.length() - 4, phone_number.length()));

        return answer.toString();
    }
}
