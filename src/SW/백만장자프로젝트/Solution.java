package SW.백만장자프로젝트;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        // 제일 큰 값을 찾아서, 작은 값들을 팔면

        for (int test_case = 1; test_case <= T; test_case++) {
            int size = sc.nextInt();
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println("#" + test_case + " " + go(arr));
        }
    }

    private static long go(int[] arr) {
        long max = Long.MIN_VALUE;
        long answer = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= max) { // 최댓값 갱신
                max = Math.max(max, arr[i]);
            } else {
                answer += (max - arr[i]); // 이득 더해주기
            }
        }
        return answer;
    }
}
