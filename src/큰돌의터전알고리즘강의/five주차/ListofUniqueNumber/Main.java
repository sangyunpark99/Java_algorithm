package 큰돌의터전알고리즘강의.five주차.ListofUniqueNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[100001];
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;

        int start = 0;
        int end = 0;

        while(end < n){
            if(cnt[numbers[end]] == 0){ // 중복이 되지 않는 경우
                cnt[numbers[end]]++; // 수 추가
                end++;
            }else{ // 중복이 되는경우
                answer += (end - start); // 0부터 인덱스 시작
                cnt[numbers[start]]--; // 수 감소
                start++;
            }
        }

        answer += (long) (end - start) * (end - start + 1) / 2;

        System.out.println(answer);
    }
}