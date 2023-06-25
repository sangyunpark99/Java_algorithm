package pre코딩테스트연습.one_four.five;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"naver","kakao"}));
    }

    public static String solution(String[] arr){
        String answer = "";

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
            if(i < arr.length - 1){
                answer += ",";
            }
        }

        return answer;
    }
}
