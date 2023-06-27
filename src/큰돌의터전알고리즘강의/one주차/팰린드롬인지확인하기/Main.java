package 큰돌의터전알고리즘강의.one주차.팰린드롬인지확인하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 문자열 뒤집는 내장함수 StringBuffer - reverse()
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuffer sb = new StringBuffer(s);
        String reversS = String.valueOf(sb.reverse());

        if(s.equals(reversS)){
            System.out.println(1);
            return;
        }

        System.out.println(0);
    }
}
