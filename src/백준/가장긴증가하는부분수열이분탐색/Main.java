package 백준.가장긴증가하는부분수열이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int n;
    public static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                lis.add(num);
            } else {
                int left = 0;
                int right = lis.size();

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (lis.get(mid) < num) { // 더 작은 경우
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                lis.set(left, num); // 부분 증가 수열 갱신
            }
        }

        bw.write(lis.size() + "\n");
        bw.close();
        br.close();
    }
}