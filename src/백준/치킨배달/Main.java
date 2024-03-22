package 백준.치킨배달;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    public Node(int y, int x) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int N;
    public static int M;
    public static int[][] map;
    public static ArrayList<Node> chicken;
    public static ArrayList<Node> home;
    public static int ans;
    public static boolean[] open;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        map = new int[N][N];
        ans = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value == 1) { // 집
                    home.add(new Node(i, j));
                } else if (value == 2) { // 치킨
                    chicken.add(new Node(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];
        dfs(0, 0);
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start, int cnt) {

        if (cnt == M) { // 치킨집 열린 갯수
            // 거리를 구해야 함
            int res = 0; // 모든 집집마다 거리를 구한 값

            for (int i = 0; i < home.size(); i++) {
                int homeCloset = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) { // 열려있는 치킨집에 한해서만
                        int distance =
                                Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
                        homeCloset = Math.min(homeCloset, distance);
                    }
                }
                res += homeCloset;
            }

            ans = Math.min(ans, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) { // 원상 복구
            open[i] = true; // 개업
            dfs(i + 1, cnt + 1);
            open[i] = false; // 폐업
        }
    }
}
