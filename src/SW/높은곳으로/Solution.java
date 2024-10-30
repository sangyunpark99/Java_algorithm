package SW.높은곳으로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int value = N * (N + 1) / 2;

            if (P > N) {
                System.out.println(value);
                continue;
            }

            int cur = 0; // 0층 부터 시작

            for (int i = 1; i <= N; i++) {

                if (cur + i == P) { // 가만히 있기
                    continue;
                }

                cur += i; // 현재 가능한 최대 높이로 이동
            }
            System.out.println(cur);
        }
    }
}