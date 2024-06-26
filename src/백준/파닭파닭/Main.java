package 백준.파닭파닭;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int S;
    public static int C;
    public static List<Long> welshOnions = new ArrayList<>();
    public static long leftValue;
    public static long ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long end = Integer.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < S; i++) {
            long value = Long.parseLong(br.readLine());
            end = Math.max(end, value);
            welshOnions.add(value);
            sum += value;
        }

        // 파닭 하나당 넣을 수 있는 최대 파의 길이
        binarySearch(end);

        leftValue = sum - ret * C;

        bw.write(leftValue + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void binarySearch(long end) {

        long start = 1;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (check(mid)) {
                start = mid + 1;
                ret = mid;
            } else {
                end = mid - 1;
            }
        }
    }

    public static boolean check(long criteria) {

        int cnt = 0;

        for (int i = 0; i < welshOnions.size(); i++) {
            long value = welshOnions.get(i);

            cnt += value / criteria;
        }

        if (cnt >= C) { // 더 크거나 같은 경우
            return true;
        }

        return false;
    }
}
