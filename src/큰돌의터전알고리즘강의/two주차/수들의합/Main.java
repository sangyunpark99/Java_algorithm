package 큰돌의터전알고리즘강의.two주차.수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];

        stk = new StringTokenizer(br.readLine());

        int i = 0;
        while(stk.hasMoreTokens()){
            arr[i] = Integer.parseInt(stk.nextToken());
            i++;
        }

        int p1 = 0;
        int p2 = 0;
        int cnt = 0;

        int sum = 0;
        while(p1 < n){
            if(sum > m || p2 == n){ // p2가 이미 먼저 온경우
                sum -= arr[p1++];
            }else{
                sum += arr[p2++];
            }

            if(sum == m){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
