package 큰돌의터전알고리즘강의.two주차.미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map;
    public static int[][] visited;

    // 북동남서
    public static int[] dy = new int[] {-1,0,1,0};
    public static int[] dx = new int[] {0,1,0,-1};

    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][m];

        visited = new int[n][m];

        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i],0);
        }

        for (int i = 0; i < n; i++) {
                stk = new StringTokenizer(br.readLine());
                map[i] = Arrays.stream(stk.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
            }

        bfs(0,0);
    }

    public static void bfs(int y, int x){
        visited[y][x] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y);
        queue.add(x);

        while(queue.size()>0){
            y = queue.poll();
            x = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0) continue; // 오버플로우 먼저 하고 ny nx 체크

                if(visited[ny][nx] == 0){
                    queue.add(ny);
                    queue.add(nx);
                    visited[ny][nx] = visited[y][x] + 1;
                }
            }
        }

        System.out.println(visited[n-1][m-1]); // (0,0)부터 시작
    }
}
