package 큰돌의터전알고리즘강의.three주차.알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int R;
    public static int C;

    public static String[][]map;

    // 북동서남
    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{-1,0,1,0};

    public static int[] visited;

    public static char a = 'A';

    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        visited = new int[26]; // 아스키 코드를 활용한 알파벳

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().split("");
        }

        visited[map[0][0].charAt(0) - a] = 1;

        dfs(0,0,1);

        System.out.println(answer);
    }

    public static void dfs(int y, int x, int cnt){

        answer = Math.max(answer,cnt);

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= C || ny < 0 || ny >= R) continue;

            int next = map[ny][nx].charAt(0) - a;

            if(visited[next] == 0){ // 방문하지 않은 경우
                visited[next] = 1;
                dfs(ny, nx, cnt+1);
                visited[next] = 0; // 지나왔던 곳 방문처리 취소
            }
        }
    }
}
