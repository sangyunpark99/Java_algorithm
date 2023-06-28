package 큰돌의터전알고리즘강의.one주차.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간합
// 슬라이딩 윈도우
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        int[] list = new int[n];

        st = new StringTokenizer(br.readLine());

        int i = 0;
        while(st.hasMoreTokens()){ // 담아주기
            list[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        int maxValue = Integer.MIN_VALUE;
        int sum = 0;
        //Slidng Window
        for (int j = 0; j < list.length; j++) {
            sum += list[j];

            if(j >= size - 1){
                maxValue = Math.max(maxValue,sum); // 먼저 최댓값 판별
                sum -= list[j-(size-1)]; // 맨 앞의 원소를 제거
            }
        }

        System.out.println(maxValue);
    }
}
