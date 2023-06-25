package pre코딩테스트연습.one_four.one;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{71,111,111,103,108,101}));
    }

    public static String solution(int[] arr) {
        String answer = "";

        for (int i = 0; i < arr.length; i++) {
            answer += (char)arr[i];
        }

        return answer;
    }
}
