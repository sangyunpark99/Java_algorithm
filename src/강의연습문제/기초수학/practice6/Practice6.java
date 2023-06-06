package 강의연습문제.기초수학.practice6;

public class Practice6 {

    public static int solution(int n){
        int result = 0;

        if(n <= 1){
            return 1;
        }

        for (int i = 0; i < n; i++) {
            result += solution(i) * solution(n-i-1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(5));
        System.out.println(solution(7));
    }
}
