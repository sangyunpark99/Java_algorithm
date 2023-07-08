package pre코딩테스트연습.three_one.three;

import java.math.BigInteger;

public class Solution {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(1));
    }

    public BigInteger solution(int n) {
        // math.pow 사용 불가능 -> 분할 정복 이용해서 계산하기
        BigInteger i = new BigInteger("1");

        for (int j = 0; j < (n-1)/2; j++) {
            i = i.multiply(BigInteger.valueOf(Long.valueOf(10)));
        }

        BigInteger palindromeCount = i.multiply(BigInteger.valueOf(9)).remainder(BigInteger.valueOf(MOD));

        return palindromeCount;
    }
}
