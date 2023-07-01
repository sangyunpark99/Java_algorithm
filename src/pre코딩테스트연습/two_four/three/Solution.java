package pre코딩테스트연습.two_four.three;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("HelloWorld","WorldHello"));
    }

    public int solution(String S1, String S2) {
        int answer = 0;

        for (int i = 1; i < S1.length(); i++) {
            String a = S1.substring(0,i);
            String b = S1.substring(i);

            String change = b + a;

            if(change.equals(S2)){
                answer = 1;
                break;
            }
        }

        return answer;
    }
}
