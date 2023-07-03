package 큰돌의터전알고리즘강의.two주차.안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 반례
// 최소, 최대
// 없거나 있거나

public class Main {

    public static int n;
    public static int[][] map;
    public static int[][] visited;
    public static int[] dy = new int[]{-1,0,1,0};
    public static int[] dx = new int[]{0,1,0,-1};


    static class Node{
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()){
                map[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i],0);
        }

        // 탐방 시작
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i <= 100; i++) { // 아무 지역도 물에 잠기지 않는 경우 고려

            int value = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(map[j][k] > i && visited[j][k] == 0){ // 기준 충족
                        bfs(j,k,i);
                        value++;
                    }
                }
            }

            for (int j = 0; j < visited.length; j++) { // 방문 노드 초기화
                Arrays.fill(visited[j],0);
            }

            answer = Math.max(answer, value);
        }

        System.out.println(answer);
    }

    public static void bfs(int y, int x, int m){

        visited[y][x] = 1; // 방문처리
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(x,y);
        queue.add(node);

        while(queue.size() > 0){

            node = queue.poll(); // 가져오기

            x = node.x;
            y = node.y;

            for (int i = 0; i < 4; i++) { //4방향 탐지
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue; // 오버플로우 먼저
                if(map[ny][nx] > m && visited[ny][nx] == 0){ // 방문하지 않았다면
                    queue.add(new Node(nx,ny));
                    visited[ny][nx] = 1;
                }
            }
        }
    }
}
