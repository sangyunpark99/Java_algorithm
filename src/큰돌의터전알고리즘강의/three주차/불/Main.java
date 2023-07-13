package 큰돌의터전알고리즘강의.three주차.불;

import java.io.*;
import java.util.*;

// 불이 하나가 아닌 여러개일 수 있다.
public class Main {

    public static int R;
    public static int C;

    public static String[][] map;

    public static int[][] visitedFire;
    public static int[][] visitedHuman;

    public static int[] dx;
    public static int[] dy;

    public static Node fireLocation;
    public static Node humanLocation;

    public static Queue<Node> fireQueue;

    public static void main(String[] args) throws IOException {

        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];

        // 0으로 초기화
        visitedFire = new int[R][C];
        visitedHuman = new int[R][C];

        dx = new int[]{0,1,0,-1};
        dy = new int[]{-1,0,1,0};

        fireQueue = new LinkedList<>();

        // 맵 입력
        for (int i = 0; i < R; i++) {
            String S = br.readLine();
            for (int j = 0; j < C; j++) { // 불 좌표, 지훈이 좌표 찾기
                map[i][j] = String.valueOf(S.charAt(j));
                if(map[i][j].equals("J")){
                    humanLocation = new Node(j,i);
                }else if(map[i][j].equals("F")){ // 불이 여러개, 불이 아무것도 없을 수 있다. -> 반레
                    fireLocation = new Node(j,i);
                    fireQueue.add(fireLocation);
                    visitedFire[i][j] = 1;
                }
            }
        }

        // (1) 불이 이동할 수 있는 최단경로
        fireBfs();

        // (2) 사람이 이동할 수 있는 최단경로 + 길 비교해야함
        humanBfs(humanLocation.y, humanLocation.x);
        // 가능한 길 찾아서


        int result = Integer.MAX_VALUE;

        // (3) 가장 짧은 최단거리 찾기 (가장자리 찾기)
        for (int i = 0; i < visitedHuman.length; i++) {
            for (int j = 0; j < visitedHuman[i].length; j++) {
                if((0<i && i<R-1) && 0 < j && j < C-1)continue; // 가장자리가 아닌 경우 pass
                if(visitedHuman[i][j] > 0) {
                    result = Math.min(result, visitedHuman[i][j]);
                }
            }
        }

        if(result == Integer.MAX_VALUE){
            bw.write("IMPOSSIBLE");
        }else{
            bw.write(result);
        }

        bw.flush();
        bw.close();
    }

    public static void humanBfs(int y, int x){

        visitedHuman[y][x] = 1;

        Node node = new Node(x,y);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(queue.size()>0){
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= C || ny < 0 || ny >= R) continue;
                if(visitedHuman[ny][nx] == 0 && (map[ny][nx].equals(".") || map[ny][nx].equals("F"))){
                    if(visitedHuman[ny][nx] < visitedFire[ny][nx] || visitedFire[ny][nx] == 0){
                        visitedHuman[ny][nx] = visitedHuman[cur.y][cur.x] + 1;

                        Node next = new Node(nx,ny);
                        queue.add(next);
                    }
                }
            }
        }
    }

    public static void fireBfs(){

        while(fireQueue.size()>0){
            Node cur = fireQueue.poll();

            for (int i = 0; i < 4; i++) { // 4방향 탐지
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || nx >= C || ny < 0 || ny >= R) continue;
                if(visitedFire[ny][nx] == 0 && (map[ny][nx].equals(".") || map[ny][nx].equals("J"))){
                    visitedFire[ny][nx] = visitedFire[cur.y][cur.x] + 1;
                    Node next = new Node(nx,ny);
                    fireQueue.add(next);
                }
            }
        }
    }


    public static class Node {
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
