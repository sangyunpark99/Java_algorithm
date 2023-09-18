package 큰돌의터전알고리즘강의.three주차.꽃길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] map;
    public static int[][] visited;
    public static int[] dy = new int[]{-1,0,1,0};
    public static int[] dx = new int[]{0,1,0,-1};
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        System.out.println(answer);

    }

    public static int setFlower(int y, int x){
        int sum = map[y][x];
        visited[y][x] = 1; // 꽃 가운데

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            sum+=map[ny][nx];
            visited[ny][nx] = 1; // 주변 꽃 잎 visited 처리
        }

        return sum;
    }

    public static void removeFlower(int y, int x){ // 방문처리 취소

        visited[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            visited[ny][nx] = 0;
        }
    }

    public static void dfs(int sum, int cnt){

        if(cnt == 3){ // 종료 조건
            answer = Math.min(answer,sum);
            return;
        }

        // 다음 지점 검색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                if(check(i,j)){
                    dfs(sum+setFlower(i,j),cnt+1);
                    removeFlower(i,j); // 꽃이 있던 자리 초기화
                }
            }
        }
    }

    public static boolean check(int y, int x){ // 꽃이 들어설 수 있는 자리인지 확인하방
        if(visited[y][x] != 0) return false;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >=n || nx >=n || visited[ny][nx] != 0){
                return false;
            }
        }
        return true;
    }
}
