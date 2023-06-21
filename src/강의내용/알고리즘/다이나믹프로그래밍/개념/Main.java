package 강의내용.알고리즘.다이나믹프로그래밍.개념;

// 큰 문제를 부분 문제로 나눈 후 답을 찾아가는 과정에서,
// 계산된 결과를 기록하고 재활용하며 문제의 답을 구하는 방식
// 중간 계산 결과를 기록하기 위한 메모리가 필요
// 한 번 계산한 부분을 다시 계산하지 않아 속도가 빠름
// 중복된 연산을 하지 않아도 된다.

// 다른 알고리즘과의 차이점
// 분할 정복과의 차이
// - 분할 정복은 부분 문제가 중복되지 않음
// - DP는 부분 문제가 중복되어 재활용에 사용
// 그리디 알고리즘과의 차이
// - 그리디 알고리즘은 순간의 최선을 구하는 방식(근사치) -> 그리디 알고리즘을 적용할 수 있다면 그리디가 더 우위에 존재한다.
// - DP는 모든 방법을 확인 후 최적해 구하는 방식

// 타뷸레이션
// 상향식 접근 방법
// 작은 하위 문제부터 풀면서 올라감
// 모두 계산하면서 차례대로 올라감

// 메모이제이션
// 하향식 접근 방식
// 큰 문제에서 하위 문제를 확인해가며 진행
// 계산이 필요한 순간 계산하며 진행

public class Main{

    // 피보나치 수열 일반 풀이 방법 : O(n^2)
    // 계산했던 부분도 다시 계산
    public static int fib(int n) {
        if(n<=1){
            return n;
        }else{
            return fib(n-1) + fib(n-2);
        }
    }

    // 타뷸레이션 - O(n) - 반복문 풀이
    public static int fibDP(int n){
        int[] dp = new int[n < 2? 2: n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // 메모이제이션 - O(n)

    static int[] dp = new int[8];
    public static int fibDp2(int n){
        if(n <= 2){
            return 1;
        }

        if(dp[n] != 0){ // 해당 부분이 존재하면
            return dp[n]; // 가져다 쓰기
        }

        dp[n] = fibDp2(n - 1) + fibDp2(n - 2);

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
        System.out.println(fibDP(7));
        System.out.println(fibDp2(7));

    }
}
