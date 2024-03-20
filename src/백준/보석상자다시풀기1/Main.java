package 백준.보석상자다시풀기1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int[] jewel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        jewel = new int[M];

        for (int i = 0; i < M; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
        }

        int start = 1;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            end = Math.max(end, jewel[i]);
        }

        int answer = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2; // 보석 갯수
            if (check(mid)) {
                answer = Math.min(answer, mid);
                end = mid - 1; // 더 작은 값이 나올 수 도 있다.
            } else {
                start = mid + 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean check(int mid) {
        int value = 0;

        for (int i = 0; i < M; i++) {
            value += jewel[i] / mid;

            if (jewel[i] % mid > 0) {
                value++;
            }
        }

        return value <= N; // 인원수보다 작거나 큰 경우
    }
}
