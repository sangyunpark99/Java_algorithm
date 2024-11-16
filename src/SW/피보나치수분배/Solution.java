package SW.피보나치수분배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int t;
    public static long[] arr;

    public static int n;
    public static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int cnt = n / 3;

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < cnt; j++) { // 3자리 짝 넣기
                sb.append("BBA");
            }

            if (n % 3 == 2) { // 2개가 나온 경우
                sb.insert(0, "BA"); // 2자리 빡
            } else if (n % 3 == 1) { // 1개인경우엔 짝을 질 수 없다.
                System.out.println("impossible");
                continue;
            }

            System.out.println(sb);
        }
    }
}
