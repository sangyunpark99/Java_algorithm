package 백준.기타레슨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;

        int[] value = new int[N];

        st = new StringTokenizer(br.readLine());

        int start = Integer.MIN_VALUE;

        int i = 0;
        while (st.hasMoreTokens()) {
            value[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start, value[i]);
            i++;
        }

        int end = Arrays.stream(value).sum();

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = check(mid, value);
            // 확인하는 로직
            if (count <= M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
        br.close();
    }

    public static int check(int mid, int[] value) {
        int cnt = 1;

        int sum = 0;
        for (int i = 0; i < value.length; i++) {
            sum += value[i];
            if (sum > mid) {
                cnt++;
                sum = value[i];
            }
        }

        return cnt;
    }
}
