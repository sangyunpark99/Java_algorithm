package 백준.주사위굴리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;

    public static int diceY;
    public static int diceX;

    public static int[] dice = new int[7];

    public static int order;

    public static int[][] map;

    // 동,서,북,남
    public static int[] dy = {0, 0, -1, 1};
    public static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        diceY = Integer.parseInt(st.nextToken());
        diceX = Integer.parseInt(st.nextToken());

        order = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < order; i++) {
            int direction = Integer.parseInt(st.nextToken());
            move(direction);
        }
    }

    private static void move(int direction) { // 이동
        int ny = diceY + dy[direction - 1];
        int nx = diceX + dx[direction - 1];
        if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
            return;
        }
        roll(direction, nx, ny);
        diceY = ny;
        diceX = nx;
    }

    private static void roll(int direction, int x, int y) {
        int tmp = dice[3];
        switch (direction) {
            case 1: // 동쪾
                dice[3] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 2:
                dice[3] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 3:
                dice[3] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[1];
                dice[1] = tmp;
                break;
            case 4:
                dice[3] = dice[1];
                dice[1] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
                break;
        }

        if (map[y][x] == 0) { // 칸의 수가 0
            map[y][x] = dice[6];
        } else { // 칸의 수가 0이 아닌 경우
            dice[6] = map[y][x];
            map[y][x] = 0;
        }

        System.out.println(dice[3]);
    }
}
