package 큰돌의터전알고리즘강의.three주차.톱니바퀴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static Gear[] gears;
    public static int T;
    public static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        gears = new Gear[T];

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split("");
            gears[i] = new Gear(Arrays.stream(s).mapToInt(Integer::parseInt).toArray());
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(stk.nextToken()) - 1; // 인덱스
            int dir = Integer.parseInt(stk.nextToken());
            int[] roll = new int[T];

            roll[pos] = dir; // 주어진 포지션 회전 방향

            // 주어진 포지션을 기준으로 왼쪽 포지션
            for (int j = pos - 1; j > -1; j--) {
                Gear cur = gears[j];
                Gear prev = gears[j + 1];

                if (cur.getThree() == prev.getNine()) {
                    break;
                } else {
                    roll[j] = -1 * roll[j + 1]; // 반대 방향으로 돌려
                }
            }

            // 주어진 포지션을 기준으로 오른쪽 포지션
            for (int j = pos + 1; j < T; j++) {
                Gear cur = gears[j];
                Gear prev = gears[j - 1];
                if (prev.getThree() == cur.getNine()) {
                    break;
                } else {
                    roll[j] = -1 * roll[j - 1];
                }
            }

            // 돌려
            for (int j = 0; j < roll.length; j++) {
                if (roll[j] == -1) {
                    gears[j].rollLeft();
                }
                if (roll[j] == 1) {
                    gears[j].rollRight();
                }
            }
        }

        int count = 0;

        for (int i = 0; i < T; i++) {
            Gear cur = gears[i];
            if (cur.getTwelve() == 1) { // 12시방향이 s인경우
                count++;
            }
        }

        System.out.println(count);
    }


    static class Gear {

        // 12시 지점을 기준으로 두고 어떤 톱니바퀴가 오는지 확인
        private int[] gear;
        private int pos; // 12시 지점의 톱니바퀴

        public Gear(int[] array) {
            this.gear = array;
            pos = 0;
        }

        public void rollRight() { // 톱니바퀴 오른쪽 회전
            if (pos == 0) {
                pos = 7;
            } else {
                pos -= 1;
            }
        }

        public void rollLeft() { // 톱니바퀴 왼쪽 회전
            pos = (pos + 1) % 8;
        }

        public int getThree() { // 세번째 값 받아오기
            return gear[(pos + 2) % 8];
        }

        public int getNine() { // 아홉번째 값 받아오기
            return gear[(pos + 6) % 8];
        }

        public int getTwelve() {
            return gear[pos];
        }
    }
}
