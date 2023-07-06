package 큰돌의터전알고리즘강의.two주차.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int[][] map;
    public static int[][] visited; // visited로 시간별 체크

    public static ArrayList<ArrayList<Integer>> timeCheese;

    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public static int n;
    public static int m;

    public static int cnt;

    public static void main(String[] args) throws IOException {
        // 상하좌우가 전부 1이면 바로 안녹는다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][m];
        timeCheese = new ArrayList<>();
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        // 언제까지?
        // 전부 0이 될때까지..?
        cnt = 0;
        while(!finish(map)){ // 치즈가 전부다 녹을때 까지

            for (int i = 0; i < n; i++) { // 방문 초기화
                Arrays.fill(visited[i],0);
            }

            timeCheese.add(new ArrayList<>());
            dfs(0,0); // 한번 쭉 돌고 -> 한싸이클 외부 치즈 녹임

            cnt++;
        }

        System.out.println(cnt);
        System.out.println(timeCheese.get(timeCheese.size()-1).size()/2);

    }

    public static void dfs(int y, int x){
        visited[y][x] = 1; // 방문 처리
        if(map[y][x] == 1){ // x,y좌표 넣기
            map[y][x] = 0; // 치즈 녹이기
            timeCheese.get(cnt).add(y);
            timeCheese.get(cnt).add(x);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] == 1) continue;
            dfs(ny,nx); // 미리 안두들겨 보고 건너기
        }
    }

    public static boolean finish(int[][] arr){ // 치즈가 다 녹을때 까지
        // 전부다 0인 경우
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1){
                    return false;
                }
            }
        }

        return true;
    }
}
