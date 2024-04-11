package 백준.한국이그리울서버에접속하지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String pattern = br.readLine();

        // 별표는 문자열의 시작과 끝에 존재하지 않는다.
        String[] values = pattern.split("\\*");
        String startValue = values[0];
        String endValue = values[1];

        for (int i = 0; i < N; i++) {
            String value = br.readLine();
            if (value.startsWith(startValue)) {
                value = value.replace(startValue, "");
                if (value.endsWith(endValue)) {
                    System.out.println("DA");
                    continue;
                }
                System.out.println("NE");
            } else {
                System.out.println("NE");
            }
        }
    }
}

// 65%까지 정담
// 반례가 뭐가 있을까?
