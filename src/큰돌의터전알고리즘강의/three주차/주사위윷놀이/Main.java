package 큰돌의터전알고리즘강의.three주차.주사위윷놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    public static int[] v = new int[32];
    public static int[] dice = new int[10];
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        for (int i = 0; i < 10; i++) {
            int value = Integer.parseInt(stk.nextToken());
            dice[i] = value;
        }

        setMap();
    }

    // 인접 리스트 - 단방향
    private static void setMap() {
        for (int i = 0; i < 32; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i <= 19; i++) {
            add(i, i + 1);
        }

        // 연결
        add(5, 21);
        add(21, 22);
        add(22, 23);
        add(23, 24);
        add(24, 25);
        add(25, 26);
        add(26, 20);
        add(10, 27);
        add(27, 28);
        add(28, 24);
        add(15, 29);
        add(29, 30);
        add(30, 31);
        add(31, 24);
        add(20, 100);

        // 값 추가
        for (int i = 0; i < 20; i++) {
            v[i] = i * 2;
        }

        v[21] = 13;
        v[22] = 16;
        v[23] = 19;
        v[24] = 25;
        v[25] = 30;
        v[26] = 35;
        v[27] = 22;
        v[28] = 24;
        v[29] = 28;
        v[30] = 27;
        v[31] = 26;
    }

    private static void add(int here, int there) {
        map.get(here).add(there);
    }
}
