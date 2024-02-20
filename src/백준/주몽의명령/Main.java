package 백준.주몽의명령;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[N];

        int idx = 0;
        while (st.hasMoreTokens()) {
            array[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        Arrays.sort(array);

        int p1 = 0;
        int p2 = array.length - 1;
        int cnt = 0;

        while (p1 < p2) {
            int sum = array[p1] + array[p2];

            if (sum < M) {
                p1++;
            } else if (sum > M) {
                p2--;
            } else {
                cnt++;
                p1++;
                p2--;
            }
        }

        System.out.println(cnt);
    }
}
