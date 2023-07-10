package 큰돌의터전알고리즘강의.three주차.인구이동;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static int[][] visited;

    static int[] dx;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());

        map = new int[N][N];
        visited = new int[N][N];

        dx = new int[]{0,1,0,-1};
        dy = new int[]{-1,0,1,0};

        for (int i = 0; i < N; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 국경 찾기 - visited로 열린 국경 찾기
        // 열린 국경 : 2 | 닫힌 국경 : 1
        // 열린 국경끼리 점수 초기화 -> 다시 국경 찾기
        // 열린 국경이 없을때 까지 반복

        int result = 0;

        while(true){

            for (int i = 0; i < visited.length; i++) { // visited 배열 초기화
                Arrays.fill(visited[i],0);
            }

            if(move() == 0){
                break;
            }else{
                result++;
            }
        }

        System.out.println(result);
    }

    public static int move(){ // 움직여라!
        int count = 0;

        // 고립될 수 도 있다.
        for (int y = 0; y < N; y++) { // y
            for (int x = 0; x < N; x++) { // x
                if(visited[y][x] == 0){ // 방문하지 않은 경우
                    Queue<Node> queue = new LinkedList();
                    ArrayList<Node> list = new ArrayList<>();

                    Node node = new Node(y,x);
                    queue.add(node); // 큐에 노드 넣어주기
                    list.add(node); // 값들 넣어주기

                    int sum = map[node.y][node.x];
                    visited[node.y][node.x] = 1;

                    while(queue.size() > 0){
                        Node cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(visited[ny][nx] == 0){
                                int gap = Math.abs(map[ny][nx] - map[y][x]);
                                if(gap >= L && gap <= R){
                                    queue.add(new Node(nx,ny)); // queue에 넣고
                                    list.add(new Node(nx,ny));
                                    visited[ny][nx] = 1;
                                    count++; // 갯수 플플
                                    sum += map[ny][nx];
                                }
                            }
                        }
                    }

                    if(count > 0){

                        int average = sum / list.size();

                        for (int k = 0; k < list.size(); k++) {
                            Node cur = list.get(k);
                            map[cur.y][cur.x] = average; // map 값 조정하기
                        }
                    }
                }
            }
        }

        return count;
    }

    public static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
