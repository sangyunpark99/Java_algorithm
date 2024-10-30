package 백준.시험감독;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int A;
    public static int B;
    public static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());

        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        find(people, B, C);
    }

    public static void find(int[] people, int B, int C) {
        long cnt = 0;
        // 1. 총 감독관이 더 많은 경우
        // 2. 감독관이 더 큰 경우
        for (int value : people) {
            cnt++;
            value -= B;

            if (value > 0) {
                cnt += value / C;
                if (value % C > 0) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}