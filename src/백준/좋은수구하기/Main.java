package 백준.좋은수구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] array = new long[N];
        int idx = 0;

        while (st.hasMoreTokens()) {
            array[idx] = Long.parseLong(st.nextToken());
            idx++;
        }

        Arrays.sort(array);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            long find = array[i];
            int p1 = 0;
            int p2 = N - 1;

            while (p1 < p2) {
                long sum = array[p1] + array[p2];

                if (sum == find) {
                    if (p1 != i && p2 != i) { // 자기 자신을 좋은 수로 x
                        answer++;
                        break;
                    } else if (p1 == i) { // 자기 자신을 좋은 수로 x
                        p1++;
                    } else if (p2 == i) { // 자기 자신을 좋은 수로 ㅌ
                        p2--;
                    }
                } else if (sum < find) {
                    p1++;
                } else {
                    p2--;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
