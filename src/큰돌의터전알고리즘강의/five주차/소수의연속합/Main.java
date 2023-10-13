package 큰돌의터전알고리즘강의.five주차.소수의연속합;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[4000001];
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <=N ; i++) {
            if(check[i]) continue;
            for (int j = 2*i; j <=N; j+=i) {
                check[j] = true;
            }
        }

        for (int i = 2; i <= N; i++) {
            if(!check[i]) list.add(i);
        }

        list.add(0);

        int answer = 0;

        int low = 0;
        int high = 1;

        int sum = list.get(low);

        while(low <= high && high < list.size()){

            if(sum < N){
                sum += list.get(high++);
            }else{
                if(sum == N){
                    answer++;
                }

                sum -= list.get(low++);
            }
        }

        System.out.println(answer);

    }
}
