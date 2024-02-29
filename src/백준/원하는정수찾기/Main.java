package 백준.원하는정수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[] value;
    public static int[] findValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        value = new int[N];

        int i = 0;
        while (st.hasMoreTokens()) {
            value[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(value);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        findValue = new int[M];

        i = 0;
        while (st.hasMoreTokens()) {
            findValue[i++] = Integer.parseInt(st.nextToken());
        }

        for (int value : findValue) {
            binarySearch(value);
        }

        br.close();
    }

    public static void binarySearch(int n) {
        int left = 0;
        int right = value.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (value[mid] < n) {
                left = mid + 1;
            } else if (value[mid] > n) {
                right = mid - 1;
            } else {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
