package SW.높은곳으로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 36개 밖에 통과하지 못함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int cur = 0; // 0층 부터 시작

            for (int i = 1; i <= N; i++) { // 선택지

                cur = cur + i; //

                if (cur == P) { // 폭탄 층수를 지나간다면 1만 빼줘도 된다.
                    cur -= 1;
                }
            }

            System.out.println(cur);
        }
    }
}