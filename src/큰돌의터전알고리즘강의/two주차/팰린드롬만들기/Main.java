package 큰돌의터전알고리즘강의.two주차.팰린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        if(!isPalindrome(s)){
            for (int i = 0; i < s.length(); i++) {
                String a = s.substring(i);
                if(isPalindrome(a)){
                    s += s.substring(0,i);
                    break;
                }
            }
        }

        System.out.println(s.length());
    }

    public static boolean isPalindrome(String s){
        int p1 = 0;
        int p2 = s.length()-1;

        boolean ans = true;

        // 투 포인터
        while(p1 < p2){
            if(s.charAt(p1) != s.charAt(p2)){
                ans = false;
                break;
            }else{
                p1++;
                p2--;
            }
        }

        return ans;
    }
}
