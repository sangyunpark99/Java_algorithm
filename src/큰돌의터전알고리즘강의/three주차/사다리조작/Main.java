package 큰돌의터전알고리즘강의.three주차.사다리조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int h;

    public static int[][] visited;

    public static int ret = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        visited = new int[34][34]; // 범위가 이해가 안됨

        for (int i = 0; i < m; i++) { // 사다리 탐지
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited[a][b] = 1; // indexing
        }

        go(1,0);

        System.out.println(ret);

    }

    public static void go(int here, int cnt){
        if(cnt > 3 || cnt >= ret) return; // 3보다 큰경우

        // 확인 -> i번째에서 출발해서 i번째에 도착하는지 유무
        if(check()){
            ret = Math.min(cnt,ret);
            return;
        }

        for (int i = here; i <= h; i++) { // 사다리를 놓을 수 있는 총 갯수
            for (int j = 1; j <= m; j++) { // 사다리가 이어지면 안된다.
                if(visited[i][j] > 0 || visited[i][j-1] > 0 || visited[i][j+1] >0) continue;
                // 백트래킹
                visited[i][j] = 1; // 사다리 놓기
                go(i, cnt+1);
                visited[i][j] = 0; // 사다리 철거
            }
        }
    }

    public static boolean check(){ // 시작 사다리와 도착 사다리가 같은 경우

        for (int i = 1; i <= n; i++) {
            int start = i;
            for (int j = 1; j <= h; j++) { // 세로선 마다 가로선을 놓을 수 있는 갯수
                if(visited[j][start] > 0) start++; // 자신을 기준으로 오른쪽에 사다리가 놓인경우
                else if(visited[j][start-1] > 0) start--; // 자신의 기준 왼쪽에 사다리가 놓인경우
            }

            if(start != i){ // 자기자신으로 돌아오지 않는 경우
                return false;
            }
        }

        return true;
    }
}
