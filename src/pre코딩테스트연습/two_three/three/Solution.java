package pre코딩테스트연습.two_three.three;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("2*3+5/6*3+15"));
    }

    public String solution(String S) {
        double answer = 0;

        String num = S.replaceAll("[0-9]","");
        String op = S.replaceAll("[^0-9]","");

        System.out.println(num);
        System.out.println(op);
        
        return String.format("%.2f",answer);
    }
}
