package 프로그래머스.최대공약수와최소공배수;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3,12)));
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n,m);
        answer[1] = (n*m)/answer[0];

        return answer;
    }

    public static int gcd(int n, int m){
        if(n%m == 0){
            return m;
        }
        return gcd(m, n%m);
    }
}
