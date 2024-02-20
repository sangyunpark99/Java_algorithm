package 백준.구간합구하기3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        long[] array = new long[N];
        int idx = 0;
        while (stk.hasMoreTokens()) {
            array[idx] = Long.parseLong(stk.nextToken());
            idx++;
        }

        long[] S = new long[N];

        S[0] = array[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + array[i];
        }

        long answer = 0;
        long[] C = new long[M];

        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);

            if (remainder == 0) {
                answer++;
            }

            C[remainder]++; // 나머지를 인덱스로해서 더해주기
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) { // 여러개 인경우 2개 조합으로 골라야 한다.
                answer = answer + (C[i] * (C[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
