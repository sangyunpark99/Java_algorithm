package 백준.백조의호수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int R;
    public static int C;

    public static Node swan;
    public static String[][] map;

    public static Queue<Node> waterQ;
    public static Queue<Node> waterTempQ;
    public static Queue<Node> swanQ;
    public static Queue<Node> swanTempQ;

    public static int[][] visited_water;
    public static int[][] visited_swan;

    public static int[] dy = new int[]{-1, 0, 1, 0};
    public static int[] dx = new int[]{0, 1, 0, -1};

    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        waterQ = new LinkedList<>();
        waterTempQ = new LinkedList<>();
        swanQ = new LinkedList<>();
        swanTempQ = new LinkedList<>();
        map = new String[R][C];
        visited_swan = new int[R][C];
        visited_water = new int[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].equals("L")) {
                    swan = new Node(i, j);
                }
                if (map[i][j].equals(".") || map[i][j].equals("L")) { // 물로 친다.
                    visited_water[i][j] = 1; // 백조가 있는 위치도 물이다.!
                    waterQ.add(new Node(i, j));
                }
            }
        }

        swanQ.add(swan);
        visited_swan[swan.y][swan.x] = 1;

        while (!moveSwan()) { // 백조 만날때까지!
            meltingWater();
            waterQ = new LinkedList<>(waterTempQ);
            swanQ = new LinkedList<>(swanTempQ);

            waterTempQ.clear();
            swanTempQ.clear();
            cnt++; // 횟수
        }

        System.out.println(cnt);
    }

    public static boolean moveSwan() {
        while (!swanQ.isEmpty()) {
            Node cur = swanQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= C || ny < 0 || ny >= R || visited_swan[ny][nx] > 0) {
                    continue;
                }
                visited_swan[ny][nx] = 1;

                if (map[ny][nx].equals(".")) {
                    swanQ.add(new Node(ny, nx));
                } else if (map[ny][nx].equals("X")) {
                    swanTempQ.add(new Node(ny, nx));
                } else if (map[ny][nx].equals("L")) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void meltingWater() { // 물은 이미 다 방문처리가 되어있음
        while (!waterQ.isEmpty()) {
            Node cur = waterQ.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= R || nx < 0 || nx >= C || visited_water[ny][nx] > 0) {
                    continue;
                }

                if (map[ny][nx].equals("X")) {
                    visited_water[ny][nx] = 1;
                    map[ny][nx] = ".";
                    waterTempQ.add(new Node(ny, nx));
                }
            }
        }
    }

    public static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}