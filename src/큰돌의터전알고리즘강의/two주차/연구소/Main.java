package 큰돌의터전알고리즘강의.two주차.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 조합
    // dfs

    public static int[][] map;
    public static int[][] visited;

    // 동북서남
    public static int[] dy = new int[]{-1,0,1,0};
    public static int[] dx = new int[]{0,1,0,-1};

    public static int solution = Integer.MIN_VALUE;

    public static ArrayList<ArrayList<Integer>> wallList;
    public static ArrayList<ArrayList<Integer>> virusList;

    // n,m
    public static int n;
    public static int m;

    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) { // 맵 초기화
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 벽좌표, 바이러스 좌표
        wallList = new ArrayList<ArrayList<Integer>>();
        virusList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){ // 벽인 경우 좌표 추가하기
                    ArrayList<Integer> dot = new ArrayList<>();
                    dot.add(i);
                    dot.add(j);
                    wallList.add(dot);
                }else if(map[i][j] == 2){ // 바이러스인 경우
                    ArrayList<Integer> dot = new ArrayList<>();
                    dot.add(i);
                    dot.add(j);
                    virusList.add(dot);
                }
            }
        }

        // 벽을 세울 좌표 선택하기 - 조합으로 세우기
        for (int i = 0; i < wallList.size(); i++) {
            for (int j = i+1; j < wallList.size(); j++) {
                for (int k = j+1; k < wallList.size(); k++) {
                    // 일단 벽을 세워
                    map[wallList.get(i).get(0)][wallList.get(i).get(1)] = 1;
                    map[wallList.get(j).get(0)][wallList.get(j).get(1)] = 1;
                    map[wallList.get(k).get(0)][wallList.get(k).get(1)] = 1;

                    // 바이러스 퍼트리기
                    ans = Math.max(solve(),ans); // 메소드를 두어서 처리한

                    // 벽을 허물어
                    map[wallList.get(i).get(0)][wallList.get(i).get(1)] = 0;
                    map[wallList.get(j).get(0)][wallList.get(j).get(1)] = 0;
                    map[wallList.get(k).get(0)][wallList.get(k).get(1)] = 0;
                }
            }
        }

        System.out.println(ans);
    }

    public static void dfs(int y, int x){ // 바이러스 퍼트리기

        visited[y][x] = 1; // 전염 시키기

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
            if(map[ny][nx] == 0 && visited[ny][nx] == 0){ // 전염이 안됐고, 방문을 하지 않은 경우 | 벽, 바이러스 제외
                dfs(ny,nx);
            }
        }

        return;
    }

    public static int solve() {
        for (int i = 0; i < visited.length; i++) { // visited 초기화
            Arrays.fill(visited[i], 0);
        }

        for (int l = 0; l < virusList.size(); l++) { // 바이러스 좌표
            int y = virusList.get(l).get(0); // y좌표
            int x = virusList.get(l).get(1); // x좌표

            visited[y][x] = 1; // 1 넣어줘

            dfs(y, x); // dfs 돌려서 감염시켜
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && visited[i][j] == 0) { // 벽, 바이러스가 아닌 경우
                    cnt++;// 갯수 증가
                }
            }
        }
        return cnt;
    }
}
