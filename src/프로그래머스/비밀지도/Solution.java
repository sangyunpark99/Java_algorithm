package 프로그래머스.비밀지도;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{46,33,33,22,31,50},new int[]{27,56,19,14,14,10}));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2){
        String[] answer = new String[arr1.length];

        for (int i = 0; i < n; i++) {
            // 2진수 변환
            String arr1Num = convertBinary(arr1[i]);
            String arr2Num = convertBinary(arr2[i]);

            // 겹치는 부분과 안겹치는 부분 return
            String sumNum = makeMap(arr1Num, arr2Num, n);

            answer[i] = convertMiro(sumNum);

        }

        return answer;
    }

    public static String makeMap(String a, String b,int n){

        StringBuffer s = new StringBuffer();

        int aLength = a.length();
        if(a.length() < n){
            for (int i = 0; i < n - aLength; i++) {
                a = "0" + a;
            }
        }

        int bLength = b.length();
        if(b.length() < n){
            for (int i = 0; i < n - bLength; i++) {
                b = "0" + b;
            }
        }

        for (int i = 0; i < n; i++) {
            if(a.charAt(i) == '1' || b.charAt(i) == '1'){
                s.append('1');
            }else if(a.charAt(i) == '0' || b.charAt(i) == '0'){
                s.append('0');
            }else{ // 공백인경우
                System.out.println("1자리 남아,");
            }
        }

        return s.toString();
    }

    public static String convertMiro(String a){ // 문자로 전환

        StringBuffer ans = new StringBuffer();

        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == '0'){
                ans.append(' ');
            }else{
                ans.append('#');
            }
        }

        return ans.toString();
    }

    public static String convertBinary(int n){

        StringBuffer base2 = new StringBuffer();

        while(n > 0){ // 몫이 0보다 클때까지
            base2.append(n%2);
            n /= 2;
        }

        return base2.reverse().toString();
    }
}
