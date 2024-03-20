package 백준.암기왕다시풀기1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] note1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // 이분 탐색은 정렬이 꼭 필요하다
            Arrays.sort(note1);

            int m = Integer.parseInt(br.readLine());
            int[] note2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < note2.length; j++) {
                sb.append(binarySearch(note1, note2[j]) + "\n");
            }
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static int binarySearch(int[] note1, int n) {
        int start = 0;
        int end = note1.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (n == note1[mid]) {
                return 1;
            } else if (n < note1[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}
