package 백준.트럭주차;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int A;
    public static int B;
    public static int C;
    public static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cnt = new int[101];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j < end; j++) {
                cnt[j]++;
            }
        }

        int answer = 0;

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 3) {
                answer += C * 3;
            } else if (cnt[i] == 2) {
                answer += B * 2;
            } else if (cnt[i] == 1) {
                answer += A;
            }
        }

        System.out.println(answer);
    }
}
