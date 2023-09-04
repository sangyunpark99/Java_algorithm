package 큰돌의터전알고리즘강의.three주차.백조의호수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int r;
    public static int c;

    public static Node swan;

    public static Queue<Node> waterQ;
    public static Queue<Node> waterTempQ;
    public static Queue<Node> swanQ;
    public static Queue<Node> swanTempQ;

    public static String[][] map;
    public static int[][] visited_water;
    public static int[][] visited_swan;

    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};

    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()); // y 값
        c = Integer.parseInt(st.nextToken()); // x 값
        waterQ = new LinkedList<>();
        waterTempQ = new LinkedList<>();
        swanQ = new LinkedList<>();
        swanTempQ = new LinkedList<>();
        map = new String[r][c];
        visited_water = new int[r][c];
        visited_swan = new int[r][c];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().split("");
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j].equals("L")){
                    swan = new Node(i,j); // 첫 백조 위치
                }
                if(map[i][j].equals(".") || map[i][j].equals("L")){ // 물 위치, 백조위치 전부 다 넣기
                    visited_water[i][j] = 1;
                    waterQ.add(new Node(i,j)); // 물 위치
                }
            }
        }

        swanQ.add(swan);
        visited_swan[swan.y][swan.x] = 1;

        while (!moveSwan()) { // 백조를 만나지 않을 때까지 - 시작하자마자 만날 수 있음
            melting();
            waterQ = new LinkedList<>(waterTempQ);
            swanQ = new LinkedList<>(swanTempQ);
            waterTempQ.clear(); // 클리어를 해주어야 한다.
            swanTempQ.clear(); // 클리어를 해주어야 한다.
            cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean moveSwan() { // 1턴에 첫번재 백조 움직임

        while(!swanQ.isEmpty()){

            Node cur = swanQ.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx < 0 || nx >= c || ny < 0 || ny >= r || visited_swan[ny][nx] > 0) continue;
                visited_swan[ny][nx] = 1;
                if(map[ny][nx].equals(".")){ // 같은 턴 내에
                    swanQ.add(new Node(ny,nx));
                }else if(map[ny][nx].equals("X")){ // 다른 턴에 시작해야할 위치
                    swanTempQ.add(new Node(ny,nx));
                }else if(map[ny][nx].equals("L")){ // 또다른 백조를 만난 경우
                    return true;
                }
            }
        }

        return false;
    }

    public static void melting(){ // 녹이기
        while(!waterQ.isEmpty()){
            Node cur = waterQ.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx < 0 || nx >= c || ny < 0 || ny >= r || visited_water[ny][nx] > 0) continue;

                if(map[ny][nx].equals("X")){
                    visited_water[ny][nx] = 1;
                    waterTempQ.add(new Node(ny,nx));
                    map[ny][nx] = ".";
                }
            }
        }
    }

    public static class Node{
        int y;
        int x;

        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
