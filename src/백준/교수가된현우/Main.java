package 백준.교수가된현우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수학, 정수론
public class Main {

    public static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int value = Integer.parseInt(br.readLine());
            System.out.println(findZero(value));
        }
    }

    public static int findZero(int value) {
        int two = 0;
        int five = 0;

        for (int i = 2; i <= value; i *= 2) { // 2의 갯수 찾기
            two += value / i;
        }

        for (int i = 5; i <= value; i *= 5) { // 5의 갯수 찾기
            five += value / i;
        }

        return Math.min(two, five);
    }
}