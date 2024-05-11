package 백준.기상캐스터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int H;
    public static int W;

    public static char[][] map;
    public static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        answer = new int[H][W];

        for (int i = 0; i < H; i++) { // 2차원 배열은 Arrays.fill
            Arrays.fill(answer[i], -1);
        }

        for (int i = 0; i < H; i++) { // map 초기화
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < H; i++) { // 줄별로
            int cnt = -1; // 구름을 만나지 않은 경우
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'c') { // 구름을 만난 경우
                    answer[i][j] = 0;
                    cnt = j; // 구름 인덱스
                } else if (cnt != -1) { // 이미 앞에 구름이 존재한다면
                    answer[i][j] = j - cnt; // 현재 index - 구름 index
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}