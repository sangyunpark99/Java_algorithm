package SW.View;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();

        // 제일 큰 값을 찾아서, 작은 값들을 팔면

        for (int test_case = 1; test_case <= 10; test_case++) {
            int size = sc.nextInt();
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("#" + test_case + " " + go(arr));
        }
    }

    private static long go(int[] arr) {
        long answer = 0;
        long left = 0;
        long right = 0;
        for (int i = 2; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i - 2]) { // 왼쪽
                left = Math.min(arr[i] - arr[i - 1], arr[i] - arr[i - 2]);
            } else {
                continue;
            }

            if (arr[i] > arr[i + 1] && arr[i] > arr[i + 2]) { // 오른쪽
                right = Math.min(arr[i] - arr[i + 1], arr[i] - arr[i + 2]);
            } else {
                continue;
            }
            answer += Math.min(left, right);
        }
        return answer;
    }
}