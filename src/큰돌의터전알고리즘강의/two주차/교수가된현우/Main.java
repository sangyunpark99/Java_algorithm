package 큰돌의터전알고리즘강의.two주차.교수가된현우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 범위가 너무 크다
// 10의자리 ? 2*5
// 2의 갯수와 5의 갯수를 알아야함
// 2의 승수로 구한다.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int num = Integer.parseInt(br.readLine());

            int ret2 = 0;
            int ret5 = 0;

            for (int j = 2; j <= num; j*=2) { // 2의 승수
                ret2 += num/j;
            }

            for (int j = 5; j <= num; j*=5) { // 5의 승수
                ret5 += num/j;
            }

            System.out.println(ret5);
        }
    }
}
