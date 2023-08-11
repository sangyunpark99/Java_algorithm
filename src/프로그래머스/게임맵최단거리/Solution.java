package 프로그래머스.게임맵최단거리;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // 북 동 서 남
    public static int[] dy = new int[]{-1,0,1,0};
    public static int[] dx = new int[]{0,1,0,-1};

    // 방문 여부
    public static int[][] visited;
    public static int n;
    public static int m;

    public int solution(int[][] maps) {
        int answer = -1;

        n = maps.length;
        m = maps[0].length;

        visited = new int[n+1][m+1];

        for (int i = 0; i < visited.length; i++) { // 방문 초기화
            Arrays.fill(visited[i],0);
        }

        bfs(0,0, maps); // 0,0 부터 시작

        if(visited[n-1][m-1] > 0){
            answer = visited[n-1][m-1];
        }

        return answer;
    }

    // 최단거리 - BFS
    public void bfs(int y, int x, int[][] maps){
        visited[y][x] = 1;

        Node node = new Node(y,x);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){

            Node current = queue.poll();

            int cur_y = current.y;
            int cur_x = current.x;

            for (int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(visited[ny][nx] == 0 && maps[ny][nx] == 1){ // 방문하지 않았고, 갈 수 있는 길인경우
                    visited[ny][nx] = visited[cur_y][cur_x] + 1; // 이전 방문한 값 + 1
                    queue.add(new Node(ny,nx));
                }
            }
        }
    }

    class Node {
        int x;
        int y;

        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}
        }));
    }
}
