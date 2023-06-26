package pre코딩테스트연습.one_five.two;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(7));
    }

    public static boolean solution(int n){
        boolean answer = true;

        for (int i = 2; i < n; i++) {
            if(n%i == 0){
                answer = false;
                break;
            }
        }

        return answer;
    }
}
