package 제로베이스코딩테스트.two;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static int count = 0;
    public static int[] visited;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new String[]{"제로","베이스","자바","스쿨","베이스","베이스","백엔드","화이팅"}));
    }

    public int solution(String[] names) {
        // 중복제거
        HashSet<String> set  = new HashSet<>(Arrays.asList(names));

        // 조합

        // 팩토리얼로 구하기
        // n! / r! * (n-r)!

        BigInteger[] dp = new BigInteger[101];
        dp[0] = BigInteger.valueOf(1);
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(2);
        for (int i = 3; i <=100; i++) {
            dp[i] = dp[i-1].multiply(BigInteger.valueOf(i));
        }

        BigInteger answer = dp[set.size()].divide(dp[4].multiply(dp[set.size()].subtract(dp[4])));
        System.out.println(dp[6].divide(dp[4].multiply(dp[6].subtract(dp[4]))));
        System.out.println(answer);

        return Integer.parseInt(String.valueOf(answer));
    }

    public static int combi(int n, int r){
        if(r == 0 || n == r){
            return 1;
        } else{
            return combi(n-1,r-1) + combi(n-1,r);
        }
    }
}
