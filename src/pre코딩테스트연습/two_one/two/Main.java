package pre코딩테스트연습.two_one.two;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().solution(new int[]{2,3,3,20}));
    }

    public int solution(int[] arr) {
        int answer = 0;

        Arrays.sort(arr);

        int sum = 0;
        for (int i = 1; i < arr.length-1; i++) {
            sum+=arr[i];
        }

        return sum/(arr.length-2);
    }
}
