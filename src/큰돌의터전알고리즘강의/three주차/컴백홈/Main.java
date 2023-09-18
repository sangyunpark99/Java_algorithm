package 큰돌의터전알고리즘강의.three주차.컴백홈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int R;
    public static int C;
    public static int K;

    public static String[][] map;
    public static int[][] visited;

    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{-1,0,1,0};

    public static int answer;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        answer = 0;

        map = new String[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().split("");
        }

        int flag = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j].equals("T")){
                    visited[i][j] = 1; //
                    flag = 1;
                    break;
                }
            }

            if (flag == 1){
                break;
            }
        }

        visited[R-1][0] = 1;
        dfs(R-1,0);

        System.out.println(answer);

    }

    public static void dfs(int y, int x){
        if(y == 0 && x == C-1){ // 집에 도착한 경우
            if(visited[y][x] == K){ // 정답인 경우
                answer+=1;
            }

            return;
        }

        // 다음으로 이동할 경로
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= C || ny < 0 || ny >= R) continue;
            if(visited[ny][nx] == 0 && map[ny][nx].equals(".")){ // 방문하지 않았다면
                visited[ny][nx] = visited[y][x] + 1; // 방문처리하고
                dfs(ny, nx); // 다음 이동경로 찾아
                // 찾거나 못찾은 경우
                visited[ny][nx] = 0; // 방문기록 지워
                 // 방문횟수 1개 빼주
            }
        }
    }
}
