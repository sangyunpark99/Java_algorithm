package 큰돌의터전알고리즘강의.two주차.비밀번호발음하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String a = "aeiou";

    public static void main(String[] args) throws IOException {

        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String word = br.readLine();

            if(word.equals("end")){
                break;
            }

            solution(word);
        }
    }

    public static void solution(String word){

        int lcnt = 0;
        int vcnt = 0; // 자음 연속

        int isInclude = 0;
        int flag = 0;

        String prev = ""; // 이전 글자
        for (int i = 0; i < word.length(); i++) { // 모음 갯수
            String w = String.valueOf(word.charAt(i));
            if(a.contains(w)){
                lcnt++;
                vcnt = 0;
                isInclude = 1; // 모음이 존재함
            }else{
                vcnt++; // 자음 추가
                lcnt = 0; // 모음 0
            }
            if(lcnt == 3 || vcnt == 3) flag = 1; // 이미 3개? flag에 1선언
            if(i>=1 && prev.equals(w) && (!prev.equals("e") && !prev.equals("o"))){ // 이전값과 같으면서 e,o가 아닌 경우
                flag = 1;
            }

            prev = w; // 이전값 초기화
        }

        if(isInclude == 0){
            flag = 1;
        }
        if(flag == 0){
            System.out.printf("<%s> is acceptable.\n",word);
        }else{
            System.out.printf("<ptoui> is not acceptable.\n",word);
        }
    }
}
