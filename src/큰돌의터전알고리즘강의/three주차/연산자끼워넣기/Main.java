package 큰돌의터전알고리즘강의.three주차.연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[] arr;
    public static int[] operator; // +, -, *, /

    public static int maxValue = Integer.MIN_VALUE;
    public static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 완전탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        operator = new int[4];

        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(stk.nextToken());
        }

        go(arr[0], 0, operator[0], operator[1], operator[2], operator[3]);

        System.out.println(maxValue);
        System.out.println(minValue);

    }

    public static void go(int cur, int index, int plus, int minus, int multi, int divide) {
        if (index == N - 1) {
            maxValue = Math.max(cur, maxValue);
            minValue = Math.min(cur, minValue);
            return;
        }

        if (plus > 0) {
            go(cur + arr[index + 1], index + 1, plus - 1, minus, multi, divide);
        }

        if (minus > 0) {
            go(cur - arr[index + 1], index + 1, plus, minus - 1, multi, divide);
        }

        if (multi > 0) {
            go(cur * arr[index + 1], index + 1, plus, minus, multi - 1, divide);
        }

        if (divide > 0) {
            go(cur / arr[index + 1], index + 1, plus, minus, multi, divide - 1);
        }
    }
}
