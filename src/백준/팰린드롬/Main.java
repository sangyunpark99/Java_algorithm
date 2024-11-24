package 백준.팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[] a;
    public static int M;
    public static int[][] dp; // S 부터 E 까지


    // StringBuilder로 하니 초과가 안나온다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[N + 2];

        // index는 1부터 시작

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) { // 자기 자신은 펠린드롬
            dp[i][i] = 1;
        } // N

        // 이전값과 다음 값이 같으면 펠린드롬 - 바로 옆에 있는 펠린드롬
        for (int i = 1; i <= N; i++) { // 연속 되어 있는 값
            if (a[i] == a[i + 1]) {
                dp[i][i + 1] = 1;
            }
        } // N

        // 사이의 값이 여러개 인경우
        for (int size = 2; size <= N; size++) { // 2부터인 이유는 3개 확인
            for (int i = 1; i <= N - size; i++) { // 확인하고자 하는 배열의 크기만큼
                if (a[i] == a[i + size] && dp[i + 1][i + size - 1] == 1) {
                    dp[i][i + size] = 1;
                }
            }
        } // (N - 1) * ( N - 2 ) N^2

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E] + "\n");
        }

        System.out.println(sb);
    }
}