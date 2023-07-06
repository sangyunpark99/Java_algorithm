package 큰돌의터전알고리즘강의.two주차.동전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        Integer[] coin = new Integer[n];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin, Collections.reverseOrder());

        int answer = 0;
        for (int i = 0; i < coin.length; i++) {
            int value = coin[i];
            if(k >= value){
                answer+= k/value;
                k %= coin[i]; // 나머지
            }
        }

        System.out.println(answer);
    }
}
