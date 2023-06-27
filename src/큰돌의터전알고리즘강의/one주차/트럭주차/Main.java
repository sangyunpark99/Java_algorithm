package 큰돌의터전알고리즘강의.one주차.트럭주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // counting 배열 - index 이용, 시각은 항상 이상 ~ 미만
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;

        int[][] truck = new int[3][2];
        int[] arr = new int[100]; // 1과 100 사이

        int answer = 0;

        for (int i = 0; i < 3; i++) {
           st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());

           truck[i][0] = start; // 시작값
           truck[i][1] = end; // 끝나는 값

            for (int j = start; j < end; j++) { // 시간은 이상 - 미만
                arr[j]++; // 시작 - 끝 값 +1해주기
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                if(truck[i][j] < first) first = truck[i][j]; // 제일 먼저시작
                if(truck[i][j] > last) last = truck[i][j];// 제일 늦게 나감
            }
        }

        for (int i = first; i < last; i++) {
            if(arr[i] == 1) answer += arr[i]*A;
            if(arr[i] == 2) answer += arr[i]*B;
            if(arr[i] == 3) answer += arr[i]*C;
        }

        System.out.println(answer);

    }
}
