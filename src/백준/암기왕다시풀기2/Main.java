package 백준.암기왕다시풀기2;

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

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {

            int N = Integer.parseInt(br.readLine());
            int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int M = Integer.parseInt(br.readLine());
            int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(arr1);

            for (int value : arr2) {
                sb.append(find(arr1, value) + "\n");
            }

            T--;
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static int find(int[] arr1, int value) {
        int start = 0;
        int end = arr1.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr1[mid] == value) {
                return 1;
            } else if (arr1[mid] < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
}