package 백준.먹을것인먹힐것인가;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int T;
    public static int N;
    public static int M;
    public static int[] A;
    public static int[] B;

    public static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 정렬
            Arrays.sort(A);
            Arrays.sort(B);

            for (int j = 0; j < A.length; j++) {
                binarySearch(A[j]);
            }

            bw.write(res + "\n");

            res = 0;
        }

        bw.close();
        br.close();
    }

    public static void binarySearch(int aNumber) { // 삽입해야할 index를 이진 탐색으로 찾아주면 된다!

        int start = 0;
        int end = B.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (aNumber > B[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // 이분탐색 미만을 찾는 경우
        // start는 최소 -> index는 크기 1이 더작다 = 자기 자신을 뺀 값이므로
        // end는 최대

        res += start;
    }
}