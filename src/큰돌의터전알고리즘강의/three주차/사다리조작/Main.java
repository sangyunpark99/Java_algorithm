package 큰돌의터전알고리즘강의.three주차.사다리조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        visited = new int[34][34]; //

        for (int i = 0; i < m; i++) { // 사다리 탐지
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited[a][b] = 1; // indexing
        }

        go(1,0);

        System.out.println(ret == Integer.MAX_VALUE ? -1 : ret);

    }

    public static void go(int here, int cnt){
        if(cnt > 3 || ret <= cnt){ // 이미 3개가 넘은 경우, ret이 cnt보다 더 작은 경우(최소)
            return;
        }

        if(check()){ // 어라랏 도착 완료!
            ret = Math.min(ret,cnt);
            return;
        }

        for (int i = here; i <= h; i++) {
            for (int j = 1; j <= n; j++){
                if(visited[i][j] != 0 || visited[i][j-1] != 0 || visited[i][j+1] != 0) continue;
                visited[i][j] = 1;
                go(i, cnt+1);
                visited[i][j] = 0; // 방문했던 곳 취소하기
            }
        }

    }

    public static boolean check(){ // 시작 사다리와 도착 사다리가 같은 경우
        for (int i = 1; i <= n; i++) {
            int start = i;
            for (int j = 1; j <= h; j++) {
                if(visited[j][start] == 1){
                    start++;
                }else if(visited[j][start-1] == 1){
                    start--;
                }
            }
            if(start != i){ // 쭉 다 돌았는데도 일치하지 않는 경우
                return false;
            }
        }
        return true;
    }
}
