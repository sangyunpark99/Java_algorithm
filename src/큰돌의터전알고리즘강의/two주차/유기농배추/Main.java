package 큰돌의터전알고리즘강의.two주차.유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int t;
    public static int m;
    public static int n;
    public static int k;

    public static int[][] map;

    public static int[][] visited;

    // 북동남서
    public static int[] dy = new int[] {-1,0,1,0};
    public static int[] dx = new int[] {0,1,0,-1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            n = Integer.parseInt(stk.nextToken());
            m = Integer.parseInt(stk.nextToken());
            k = Integer.parseInt(stk.nextToken());

            int answer = 0;

            map = new int[n][m];
            visited = new int[n][m];

            for (int j = 0; j < map.length; j++) { // 0으로 가득 채우기
                Arrays.fill(map[j],0);
            }

            for (int j = 0; j < map.length; j++) {
                Arrays.fill(visited[j],0);
            }

            for (int j = 0; j < k; j++) { // map 1로 넣기
                stk = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(stk.nextToken());
                int b = Integer.parseInt(stk.nextToken());

                map[a][b] = 1;
            }

            for (int j = 0; j < map.length; j++) {
                for (int l = 0; l < map[j].length; l++) {
                    if(map[i][l] == 1){
                        answer++;
                        dfs(j,l);
                    }
                }
            }

            // map 초기화
            for (int j = 0; j < map.length; j++) {
                Arrays.fill(map[j], 0);
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int y, int x){
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= n || nx >= m || map[ny][nx] == 0) continue;
            if(visited[ny][nx] == 0){
                dfs(y,x);
            }
        }

        return;
    }

}
