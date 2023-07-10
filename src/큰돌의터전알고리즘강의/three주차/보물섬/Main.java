package 큰돌의터전알고리즘강의.three주차.보물섬;

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static String[][] map;
    static int[][] visited;

    static int[] dx;
    static int[] dy;

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new String[n][m];
        visited = new int[n][m]; // 0으로 자동 초기화됨
        dx = new int[]{0,1,0,-1};
        dy = new int[]{-1,0,1,0};
        ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j].equals("L")){ // 육지를 찾은 경우
                    ans = Math.max(bfs(i,j),ans); // 제일 멀리 떨어진 경우를 찾아야 함
                }
            }
        }

        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int y, int x){ // stack 사용

        for (int i = 0; i < visited.length; i++) { // 방문 초기화
            Arrays.fill(visited[i],0);
        }

        visited[y][x] = 1; // 첫 방문 visited[y][x] = 1 로 초기화
        // 재방문 하지 않기 위해서

        int maxValue = Integer.MIN_VALUE;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));

        while(queue.size() > 0){

            Node node = queue.poll(); // 가져오기

            x = node.x;
            y = node.y;

            maxValue = Math.max(visited[y][x],maxValue);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(map[ny][nx].equals("L") && visited[ny][nx] == 0){
                    visited[ny][nx] = visited[y][x] + 1;
                    queue.add(new Node(nx,ny));
                }
            }
        }

        // 각 지점의 최댓값 찾기
        return maxValue - 1; // 자기 자신 지역 제거
    }

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
