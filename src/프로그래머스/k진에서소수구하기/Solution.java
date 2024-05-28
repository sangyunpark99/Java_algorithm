package 프로그래머스.k진에서소수구하기;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        // 1. 진법 변환
        String value = convert(883438, 3);

        // 2. 소수 세기 >> 소수 판별 | 0을 기준으로
        String[] list = value.split("0");

        System.out.println(Arrays.toString(list));

        int cnt = 0;
        for (String item : list) {
            if ("".equals(item)) {
                continue;
            }
            long num = Long.parseLong(item);
            if (check(num)) {
                cnt++;
            }
        }

        System.out.println(cnt);

        String test = "10001";
        System.out.println(Arrays.toString(test.split("0")));
    }

    public static String convert(int n, int k) {

        StringBuilder sb = new StringBuilder();

        while (n >= k) {
            sb.append(n % k);
            n /= k;
        }

        sb.append(n % k); // 마지막 추가해주어야 한다.

        return sb.reverse().toString();
    }

    public static boolean check(long value) { // 1과 자기 자신을 제외한 약수가 있는지 판별

        if (value == 1) {
            return false;
        }

        for (long i = 2; i < value; i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }
}
