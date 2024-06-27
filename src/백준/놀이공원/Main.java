package 백준.놀이공원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long n;
    static int m;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        time = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        if (n <= m) {
            System.out.println(n);
            return;
        }

        long res = binarySearch();
        long child = getChild(res - 1);

        for (int i = 0; i < m; i++) {
            if (res % time[i] == 0) { // result에 이용가능한 놀이기구
                child++;
            }
            if (child == n) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    private static long getChild(long t) {
        long childNum = m;
        for (int i = 0; i < m; i++) {
            childNum += t / time[i];
        }
        return childNum;
    }

    private static long binarySearch() {
        long start = 0;
        long end = n * 30;
        long res = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long childNum = getChild(mid);

            if (childNum < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                res = mid;
            }
        }
        return res;
    }
}