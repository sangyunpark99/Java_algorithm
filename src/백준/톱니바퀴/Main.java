package 백준.톱니바퀴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int K;
    public static int[][] wheel = new int[4][8];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            wheel[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        K = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            start(number, direction); // 시작
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += Math.pow(2, i) * wheel[i][0];
        }

        System.out.println(result);
    }

    public static void start(int idx, int dir) {
        leftSide(idx - 1, -dir); // 다음 톱니바퀴는 반대로 회전한다.
        rightSide(idx + 1, -dir); // 다음 톱니바퀴는 반대로 회전한다.
        rotation(idx, dir); // 선택된 톱니바퀴 회전
    }

    public static void leftSide(int idx, int dir) { // 왼쪽에 있는 톱니바퀴와 비교하기
        if (idx < 0) {
            return;
        }

        if (wheel[idx][2] == wheel[idx + 1][6]) { // 서로 같은 극이면 머춰
            return;
        }

        // 회전시킨 후, 이동
        leftSide(idx - 1, -dir); // 현재 톱니바퀴를 기준으로 다음 톱니바퀴를 반대로 회전
        rotation(idx, dir);
    }

    public static void rightSide(int idx, int dir) {
        if (idx > 3) {
            return;
        }

        if (wheel[idx][6] == wheel[idx - 1][2]) { // 같은 극이면
            return;
        }

        // 회전시킨 후, 이동
        rightSide(idx + 1, -dir); // 현재 톱니바퀴를 기준으로 다음 톱니바퀴를 반대로 회전
        rotation(idx, dir);
    }

    public static void rotation(int idx, int dir) {
        if (dir == 1) { // 시계 방향 : 7 -> 0, 0 -> 1,
            int tmp = wheel[idx][7];
            for (int i = 7; i > 0; i--) { // 이전 값을
                wheel[idx][i] = wheel[idx][i - 1];
            }
            wheel[idx][0] = tmp;
        } else if (dir == -1) {
            int tmp = wheel[idx][0];
            for (int i = 0; i < 7; i++) {
                wheel[idx][i] = wheel[idx][i + 1];
            }
            wheel[idx][7] = tmp;
        }
    }
}