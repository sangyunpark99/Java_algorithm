package 백준.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int K;
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        numbers = new int[N];

        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        int pSum = 0;
        for (int i = 0; i < K; i++) {
            pSum += numbers[i];
        }

        answer = pSum; // 초기값

        for (int i = K; i < N; i++) {
            pSum += numbers[i];
            pSum -= numbers[i - K];
            answer = Math.max(answer, pSum);
        }

        System.out.println(answer);
    }
}
