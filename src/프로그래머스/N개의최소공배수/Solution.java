package 프로그래머스.N개의최소공배수;

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2,6,8,14}));
    }

    // 두 수의 최소공배수 (a*b)/두 수의 최대 공약수
    public int solution(int[] arr) {
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer,arr[i]);
        }

        return answer;
    }

    public static int gcd(int a, int b){ // 최대 공약수
        if(b == 0) return a;
        else return gcd(b,a%b);
    }

    public static int lcm(int a, int b){ // 최소 공배수
        return a*b/gcd(a,b);
    }
}
