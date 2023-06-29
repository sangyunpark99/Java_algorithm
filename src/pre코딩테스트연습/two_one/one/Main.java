package pre코딩테스트연습.two_one.one;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] arr = new int[]{6,2,12,8,5,9};

        Arrays.sort(arr);

        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if(arr[i] + arr[j] > arr[k]){ // 삼각형 조건 만족
                        maxLength = Math.max(maxLength,arr[i]+arr[j]+arr[k]);
                    }
                }
            }
        }

        System.out.println(maxLength);
    }
}
