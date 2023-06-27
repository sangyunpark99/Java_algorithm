package 큰돌의터전알고리즘강의.one주차.일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) { // 값 받아오기
            int num = Integer.valueOf(br.readLine());
            arr[i] = num;
            sum += arr[i];
        }

        // 정렬
        Arrays.sort(arr);

        // 브루투 포스로 2개 찾아서 제거한값이 100인경우
        int fake1 = 0;
        int fake2 = 0;

        for (int i = 0; i < arr.length; i++) { // n * n-1 n^2
            for (int j = i+1; j < arr.length; j++) {
                if(sum - (arr[i] + arr[j]) == 100){ // 합이 100인경우
                    fake1 = arr[i];
                    fake2 = arr[j];

                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==fake1 || arr[i]==fake2){
                continue;
            }
            System.out.println(arr[i]);
        }

    }
    // 조합으로 풀고싶은데.. 하
}

