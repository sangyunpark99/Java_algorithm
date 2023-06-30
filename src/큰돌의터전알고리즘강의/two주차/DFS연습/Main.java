package 큰돌의터전알고리즘강의.two주차.DFS연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map = new int[5][5];
    public static int N;
    public static int M;

    public static int[] dy = new int[]{-1,0,1,0};
    public static int[] dx = new int[]{0,1,0,-1};

    public static int[][] visited = new int[5][5];

    public static void main(String[] args) throws IOException {

        // y,x로 풀자

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        for (int i = 0; i < visited.length; i++) { // visited
            Arrays.fill(visited[i],0);
        }

        for (int i = 0; i < N; i++) { // map 받아오기
            stk = new StringTokenizer(br.readLine());

            int j = 0;
            while(stk.hasMoreTokens()){
                map[i][j] = Integer.parseInt(stk.nextToken());
                j++;
            }
        }

        int answer = 0;

        for (int i = 0; i <N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 1 && visited[i][j] == 0){
                    answer+=1;
                    dfs(i,j);
                }
            }
        }

        System.out.println(answer);

    }

    public static void dfs(int y, int x){ // connected component
        visited[y][x] = 1;
        for (int i = 0; i < 4; i++) { // 4방향 움직이기
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue; // overflow, underflow 체크
            if(map[ny][nx] == 1 && visited[ny][nx] == 0){
                dfs(ny,nx); // 들어가!
            }
        }
        return;
    }
}
