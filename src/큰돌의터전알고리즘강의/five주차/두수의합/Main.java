package 큰돌의터전알고리즘강의.five주차.두수의합;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] arr;
    public static int x;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int s = 0;
        int e = n-1;

        while(s<e){

            int value = arr[s] + arr[e];

            if(value == x){
                answer++;
            }

            if(value <= x){
                s++;
            }else{
                e--;
            }
        }


        bw.write(answer + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
