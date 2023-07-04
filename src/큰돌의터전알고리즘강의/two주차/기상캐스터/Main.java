package 큰돌의터전알고리즘강의.two주차.기상캐스터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(stk.nextToken());
        int b = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[a][b];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i],-1);
        }

        for (int i = 0; i < a; i++) {
            stk = new StringTokenizer(br.readLine());

            String[] s = stk.nextToken().split("");

            int j = 1; // 누적
            boolean metC = false;
            for (int k = 0; k < s.length; k++) {
                if(s[k].equals("c")){
                    arr[i][k] = 0;
                    j = 1; // c만나경우 초기화
                    metC = true;
                }else{
                    if(metC){
                       arr[i][k] = j;
                       j++;
                    }
                }
            }
            metC = false;
            for (int k = 0; k < arr[i].length; k++) {
                System.out.printf(arr[i][k] + " ");
            }
            System.out.println();
        }
    }
}
