package 큰돌의터전알고리즘강의.two주차.BFS연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 가중치가 같은 알고리즘에서 최단거리 뭐?! BFS
// 방문한 정점은 다시 방문하지 않는 알고리

public class Main {

    public static int n;
    public static int m;

    // 나의 위치
    public static int my;
    public static int mx;

    // 당근마켓 위치
    public static int carrotY;
    public static int carrotX;

    // map
    public static int[][] map = new int[5][5];

    // visited
    public static int[][] visited= new int[5][5];

    // 상하 좌우
    public static int[] dy = new int[]{-1,0,1,0};
    public static int[] dx = new int[]{0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        my = Integer.parseInt(stk.nextToken());
        mx = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        carrotY = Integer.parseInt(stk.nextToken());
        carrotX = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int j = 0;
            while(stk.hasMoreTokens()){
                map[i][j] = Integer.parseInt(stk.nextToken());
                j++;
            }
        }

        for (int i = 0; i < visited.length; i++) { // 방문 초기화
            Arrays.fill(visited[i],0);
        }

        // 여기까지 입력

        bfs(my,mx); // 시작 좌표

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(visited[i]));
        }
    }

    // 같은 가중치 + 최단거리 ? BFS
    public static void bfs(int y, int x){
        visited[y][x] = 1; // 시작지점은 무조건 1을 걸어주어야 한다.
        // 양방향 간선인 경우 부가적인 로직이 생기게 된다.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(y); // 집어 넣기
        queue.add(x); // 집어 넣기
        while(queue.size()>0){
            // 2개씩 빼주기
            y = queue.poll();
            x = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0) continue; // 오버 플로우 + 언더플로우 방지
                if(map[ny][nx] == 1 && visited[ny][nx]==0){
                    // 두개씩 추가해주기
                    queue.add(ny);
                    queue.add(nx);
                    visited[ny][nx] = visited[y][x] + 1; // 이전 방문한 경로 + 1
                }
            }
        }

        System.out.println(visited[carrotY][carrotX]);
    }
}
