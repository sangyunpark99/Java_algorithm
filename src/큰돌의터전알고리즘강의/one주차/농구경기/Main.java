package 큰돌의터전알고리즘강의.one주차.농구경기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    // 카운팅 스타 - 맵과 배열~  cnt[s[0] - 'a']++;
    // 문자 -> 숫자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String answer = "";

        int[] arr = new int[26];

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String s = br.readLine();
            arr[s.charAt(0) - 'a']++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= 5){
                answer += (char)(i + 'a');
            }
        }

        if(answer.length() > 0){
            System.out.println(answer);
        }else{
            System.out.println("PREDAJA");
        }
    }
}
