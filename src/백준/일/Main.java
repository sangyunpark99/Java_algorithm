package 백준.일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = null;
        while ((s = br.readLine()) != null) {
            int N = Integer.parseInt(s);
            find(N);
        }
    }

    private static void find(int N) {
        long ret = 1;
        long cnt = 1;
        while (true) { // 모듈러 연산
            if (cnt % N == 0) {
                System.out.println(ret);
                break;
            } else {
                cnt = cnt * 10 + 1;
                cnt %= N;
                ret++;
            }
        }
    }
}