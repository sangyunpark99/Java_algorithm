package pre코딩테스트연습.three_three.four;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(12345));
    }

    public int solution(int A) {
        int answer = 0;

        int[] money = new int[] {50000,10000,5000,1000,500,100,50,10,5,1};

        for (int i = 0; i < money.length; i++) {
            if(A>=money[i]){
                answer += A/money[i];
                A %= money[i];
            }

            if (A < 1){
                break;
            }
        }

        return answer;
    }
}
