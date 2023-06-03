package 프로그래머스;

import java.util.Arrays;

public class 숫자짝꿍 {

    public static void main(String[] args) {
       String answer = Solution.solution("100","2345");
        System.out.println(answer);
    }

    class Solution {
        public static String solution(String X, String Y) {

            int[] x = new int[10];
            int[] y = new int[10];

            StringBuffer xy = new StringBuffer();

            for(String tmpx : X.split("")) x[Integer.parseInt(tmpx)]++; // O(n)
            for(String tmpy : Y.split("")) y[Integer.parseInt(tmpy)]++; // O(n)

            for (int i = 9; i >= 0; i--) { // O(10)
                while(x[i] > 0 && y[i] > 0){ // 같은 자릿수가 없어질 때까지
                    xy.append(i);
                    x[i]--;
                    y[i]--;
                }
            }

            if("".equals(xy.toString())){ // 같은 값이 아무것도 없는 경우
                return "-1";
            }else if("0".equals(xy.toString().substring(0,1))){ // 0만 존재하는 경우
                return "0";
            }else {
                return xy.toString();
            }
        }
    }
}