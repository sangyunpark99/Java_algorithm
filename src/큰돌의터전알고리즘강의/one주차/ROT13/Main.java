package 큰돌의터전알고리즘강의.one주차.ROT13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            int chNum = (int) ch;

            // 영어 대문자, 소문자 인경우
            // 13번 밀어서 일정 수를 넘어가는 경우
            if(chNum >= 65 && chNum <= 90){ // 소문자인경우
                answer += (char)(chNum + 13 > 90? chNum+13-26 : chNum + 13);
            }else if(chNum >= 97 && chNum <= 122){// 대문자인경우
                answer += (char)(chNum + 13 > 122? chNum+13-26 : chNum + 13);
            }else{
                answer += (char)chNum;
            }
        }

        System.out.println(answer);
    }
}
