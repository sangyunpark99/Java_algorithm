package 백준.용돈관리다시풀기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] money;
    public static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N];

        int start = Integer.MIN_VALUE;
        int end = 10_000 * 100_000;

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, money[i]); // 제일 큰 금액이 최소 금액이 되어야 한다, 안그러면 초기화를 계속 해주게 된다.
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            if (check(mid)) { // 인출 횟수가 같거나 적다는 것은 인출하는 액수가 크다는것 = 그 값을 더 줄여라!
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean check(int mid) {
        int value = mid;
        int cnt = 1; // 시작할때 인출 1번
        for (int i = 0; i < N; i++) {

            if (value - money[i] < 0) {
                value = mid; // 인출
                cnt++;
            }

            value -= money[i];
        }

        return cnt <= M; // 인출 횟수가 적다는 것은 액수가 크다는 것
    }
}
