package pre코딩테스트연습.two_four.one;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(25,2));
    }

    public int solution(int N, int K) {
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            String num = String.valueOf(i);

            if(num.contains(String.valueOf(K))){ // 포함하고 있는 경우

                for (int j = 0; j < num.length(); j++) {
                    if(String.valueOf(num.charAt(j)).equals(String.valueOf(K))){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
