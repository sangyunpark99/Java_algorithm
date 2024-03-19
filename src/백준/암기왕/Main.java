package 백준.암기왕;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static int T;
    public static int N;
    public static int M;

    public static int[] note1;
    public static int[] note2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            note1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(note1); // 이분 탐색에는 정렬이 꼭 필요하다.

            M = Integer.parseInt(br.readLine());
            note2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            StringBuilder answer = new StringBuilder();
            for (int value : note2) {
                answer.append(binarySearch(value) + "\n");
            }

            bw.write(answer.toString());
            bw.flush();
        }
        bw.close();
        br.close();
    }

    public static int binarySearch(int n) {
        int left = 0;
        int right = note1.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (note1[mid] == n) {
                return 1;
            } else if (note1[mid] < n) { // n이 더 큰 경우
                left = mid + 1;
            } else { // n이 더 큰경우
                right = mid - 1;
            }
        }

        // 못찾은 경우
        return 0;
    }
}
