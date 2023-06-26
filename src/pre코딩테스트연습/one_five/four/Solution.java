package pre코딩테스트연습.one_five.four;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int solution(int n){
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if(n/i == i){
                answer = i;
                break;
            }
        }

        return answer;
    }
}
