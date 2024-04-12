package 백준.곱셈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static long A;
    public static long B;
    public static long C;
    public static long ret;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        // 이 문제는 반복문으로 하는 순간 끝!

        bw.write(go(A, B) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static long go(long a, long b) {
        if (b == 1) {
            return a % C;
        }

        long ret = go(a, b / 2);
        ret = (ret * ret) % C;

        if (b % 2 == 1) {
            ret = (ret * a) % C; // 한번 더 곱해준다.
        }

        return ret;
    }
}
