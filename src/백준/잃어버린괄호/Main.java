package 백준.잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] values = br.readLine().split("-");

        int answer = 0;

        for (int i = 0; i < values.length; i++) {
            int tmp = Sum(values[i]);
            if (i == 0) {
                answer += tmp; // 맨처음만 더해주기
            } else {
                answer -= tmp; // 마지막은 빼주기
            }
        }

        System.out.println(answer);
    }

    public static int Sum(String a) {
        int sum = 0;
        String[] tmp = a.split("[+]");
        for (int i = 0; i < tmp.length; i++) {
            sum += Integer.parseInt(tmp[i]);
        }

        return sum;
    }
}
