package 백준.게임;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static long X, Y;
    public static int Z;

    public static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = (int) (Y * 100 / X);

        ans = -1;

        binarySearch();

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void binarySearch() {
        long start = 1;
        long end = 1_000_000_0000L;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (check(mid)) { // 가능해? 더 줄여
                ans = mid;
                end = mid - 1;
            } else { // 불가능해? 더 늘려
                start = mid + 1;
            }
        }
    }

    public static boolean check(long mid) { // 확인
        long nx = X + mid;
        long ny = Y + mid;

        long score = ny * 100 / nx;
        if (score != Z) { // 가능해
            return true;
        }

        return false; // 가능하지 않아
    }
}
