package 백준.사과담기게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int J;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        J = Integer.parseInt(br.readLine());

        int bucket = M; // 끝지점을 기준으로

        int[] apple = new int[J];

        for (int i = 0; i < J; i++) {
            apple[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;

        for (int i = 0; i < J; i++) {
            int value = apple[i];
            int move = 0;
            // 바구니의 끝지점을 기준으로..!
            if (value > bucket) { // 큰 경우
                move += value - bucket;
                bucket += move;
            } else if (value <= bucket - M) { // 작은 경우
                move += bucket - M + 1 - value;
                bucket -= move;
            }

            res += move;
        }

        System.out.println(res);
    }
}