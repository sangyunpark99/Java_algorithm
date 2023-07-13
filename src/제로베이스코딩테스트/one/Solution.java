package 제로베이스코딩테스트.one;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(15));
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                if(i%j == 0){ // 나눠떨어지는 경우
                    break;
                }
                if(j == i-1){
                    answer++;
                }
            }

        }

        if(n > 2){
            answer++;
        }

        return answer;
    }
}
