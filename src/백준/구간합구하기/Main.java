package 백준.구간합구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        String value = br.readLine();
        int[] array = Arrays.stream(value.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sum = new int[n];
        sum[0] = array[0];

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + array[i];
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken()) - 1;
            int b = Integer.parseInt(stk.nextToken()) - 1;

            System.out.println(sum[b] - (a > 0 ? sum[a - 1] : 0));
        }

        br.close();
    }
}
