package 강의연습문제.기초수학.practice2;

import java.util.Arrays;

public class Practice2 {

    // 19467
    public static void solution(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        
        int idx = -1;

        for (int i = arr.length-1; i >= 1; i--) { // 끝에서부터 변경해주어야 한다.
             if(arr[i] < arr[i-1]){
                idx = i-1;
                break;
            }
        }

        if(idx == -1){ // 큰 수를 못찾은 경우
            System.out.println(Arrays.toString(arr));
            return;
        }

        for (int i = arr.length-1; i > idx; i--) { // 이전 값이랑 비교할때
            if(arr[i] < arr[idx] && arr[i] != arr[i-1]){
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        solution(arr);

        arr = new int[]{1,9,4,7,6};
        solution(arr);

        arr = new int[]{1,1,2,3};
        solution(arr);
    }
}

