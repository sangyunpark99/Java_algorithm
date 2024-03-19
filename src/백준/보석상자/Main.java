package 백준.보석상자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new int[M];

        for (int i = 0; i < M; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        // 몇 개씩 나누어 줄까?
        int start = 1;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            end = Math.max(end, list[i]);
        }

        int answer = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) { // 인원수보다 더 작거나 같은 경우
                // 주어진 인원수보다 더 적다? = 분배를 다 못한다? = 나눠주는 사탕의 갯수를 줄여야 한다.
                answer = Math.min(answer, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    public static boolean check(int mid) {

        int num = 0;

        for (int i = 0; i < M; i++) {
            num += list[i] / mid; // mid개씩 나눠준다.

            if (list[i] % mid > 0) {
                num++; // 남은 것은 다른 사람에게 준다.
            }
        }

        return N >= num; // num이 인원수보다 같거나 작은 경우
    }
}
