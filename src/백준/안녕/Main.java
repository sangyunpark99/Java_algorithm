package 백준.안녕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[] l;
    public static int[] j;
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 최대 기쁨, 체력이 1 남을때까지 인사하기
        l = new int[n];
        j = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            l[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            j[i] = Integer.parseInt(st.nextToken());
        }

        go(0, 100, 0);
        System.out.println(answer);
    }

    public static void go(int a, int curL, int curJ) {

        if (curL <= 0) { // 체력이 0보다 작아지는 경우
            return;
        }

        if (a == n) {
            answer = Math.max(answer, curJ);
            return;
        }

        // 선택하는 경우
        go(a + 1, curL - l[a], curJ + j[a]);
        // 선택하지 않는 경우
        go(a + 1, curL, curJ);
    }
}
