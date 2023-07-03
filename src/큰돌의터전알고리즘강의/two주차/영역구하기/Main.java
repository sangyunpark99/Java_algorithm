package 큰돌의터전알고리즘강의.two주차.영역구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


// int형 dfs
public class Main {

    public static int m;
    public static int n;
    public static int k;

    public static int[][] map;
    public static int[][] visited;

    public static int[] dx = new int[]{0,1,0,-1};
    public static int[] dy = new int[]{1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        map = new int[m][n];
        visited = new int[m][n];

        for (int i = 0; i < map.length; i++) { // 0으로 채우기
            Arrays.fill(map[i],0);
        }

        for (int i = 0; i < k; i++) { // 입력받기
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = y1; j < y2; j++) { // 못가는 지역 초기화
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1; // 못감둥
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i],0);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if(map[y][x] == 0 && visited[y][x] == 0){
                    visited[y][x] = 1;
                    res.add(dfs(y,x)); // 한번 호출할때마다 넓이를 더해주어야 한다.)
                }
            }
        }

        Collections.sort(res);
        System.out.println(res.size());

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < res.size(); i++) {
            buffer.append(res.get(i));
            buffer.append(" ");
        }

        buffer.deleteCharAt(buffer.length()-1);

        System.out.println(buffer.toString());
        
    }

    public static int dfs(int y, int x){

        int ret = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; // 오버플로우 검출
            if (map[ny][nx] == 0 && visited[ny][nx] == 0) {
                visited[ny][nx] = 1;
                ret += dfs(ny, nx); // 정점 더해가기
            }
        }

        return ret;
    }
}
