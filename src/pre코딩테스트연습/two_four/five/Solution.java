package pre코딩테스트연습.two_four.five;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"ver","nav","nev"},"naver"));
    }

    public int solution(String[] array, String s) {
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            if(s.startsWith(array[i])){
                answer++;
            }
        }

        return answer;
    }
}
