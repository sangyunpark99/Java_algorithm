package 큰돌의터전알고리즘강의.three주차.연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 시간 초과
// 어떻게 하면 시간을 줄일 수 있을까?
public class Main {

    public static int N;
    public static int[] arr;
    public static HashMap<Integer, Integer> map;
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            answer = Math.max(answer, sum);
            if (sum < 0) { // 음수이면 버려
                sum = 0;
            }
        }

        System.out.println(answer);
    }
}