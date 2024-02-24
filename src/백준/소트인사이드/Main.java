package 백준.소트인사이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        int[] S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while (st.hasMoreTokens()) {
            A[idx++] = Integer.parseInt(st.nextToken());
        }

        // 삽입 정렬
        for (int i = 1; i < N; i++) {
            int insert_point = i;
            int insert_value = A[i];

            for (int j = i - 1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    insert_point = j + 1;
                    break;
                }

                if (j == 0) {
                    insert_point = 0;
                }
            }

            for (int j = i; j > insert_point; j--) {
                A[j] = A[j - 1];
            }

            A[insert_point] = insert_value;
        }

        S[0] = A[0]; // 합배열 만들기
        for (int i = 1; i < N; i++) { // 구간합
            S[i] = S[i - 1] + A[i];
        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum = sum + S[i];
        }
        System.out.println(sum);
    }
}
