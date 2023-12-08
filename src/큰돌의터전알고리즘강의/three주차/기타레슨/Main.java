package 큰돌의터전알고리즘강의.three주차.기타레슨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int low;
    public static int high;
    public static int ret;

    public static int[] arr;
    public static int sum;
    public static int mx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            mx = Math.max(mx, arr[i]);
        }

        // 블루레이를 몇개씩 가져가야 할까?
        low = 0;
        high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(mid)) {
                high = mid - 1;
                ret = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ret);
    }

    public static boolean check(int mid) {
        if (mx > mid) {
            return false;
        }

        int temp = mid;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (mid - arr[i] < 0) {
                mid = temp;
                cnt++;
            }

            mid -= arr[i];
        }

        if (mid != temp) {
            cnt++;
        }

        return cnt <= M;
    }
}
