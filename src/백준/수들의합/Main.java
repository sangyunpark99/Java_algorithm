package 백준.수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.valueOf(br.readLine());

        long sum = 0;
        int currentNum = 1;
        while(true){
            sum+=currentNum;
            if(sum > n){
                currentNum -= 1;
                break;
            }else{
                currentNum+=1;
            }
        }

        System.out.println(currentNum);
    }
}
