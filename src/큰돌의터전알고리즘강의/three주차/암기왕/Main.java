package 큰돌의터전알고리즘강의.three주차.암기왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static int N;
    static int M;
    static int[] nNote;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T > 0) {

            N = Integer.parseInt(br.readLine());

            nNote = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                nNote[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(nNote); // 정렬

            M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < M; i++) {
                int ret = solution(Integer.parseInt(st.nextToken()), 0, N - 1);
                sb.append(ret + "\n");
            }

            T--;
        }

        System.out.println(sb.toString());
        br.close();
    }

    static int solution(int n, int start, int end) { // 이분 탐색

        int middle;

        while (start <= end) {
            middle = (start + end) / 2;

            if (n == nNote[middle]) {
                return 1;
            } else if (nNote[middle] > n) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        return 0;
    }
}
