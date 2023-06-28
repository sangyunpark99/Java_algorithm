package 큰돌의터전알고리즘강의.one주차.주몽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 조합으로 사용?
    public static void main(String[] args) throws IOException {
        // 조합을 사용 -> 3개까지는 중첩 for문을 사용해서 구현해도 된다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];

        int i = 0;
        while(stk.hasMoreTokens()){
            numbers[i] = Integer.parseInt(stk.nextToken());
            i++;
        }

        int answer = 0;

        if(m > 200000){ // 200000인 경우 바로 return
            System.out.println(0);
            return;
        }

        for (int j = 0; j < numbers.length; j++) {
            for (int k = j+1; k < numbers.length; k++) {
                if(numbers[j] + numbers[k] == m){
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
