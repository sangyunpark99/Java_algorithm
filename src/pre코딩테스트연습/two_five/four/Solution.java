package pre코딩테스트연습.two_five.four;

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(5));
    }

    public int solution(int n) {
        BigInteger a = new BigInteger("2");
        BigInteger b = new BigInteger(String.valueOf(n));
        BigInteger result = a.pow(Integer.parseInt(String.valueOf(b))).subtract(BigInteger.ONE).mod(new BigInteger("1000000007"));
        return result.intValue();
    }
}
