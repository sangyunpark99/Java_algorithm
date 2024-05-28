package 백준.치킨배달복습1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;

    public static int[][] map;
    public static List<Node> chickens = new ArrayList<>();
    public static List<Node> homes = new ArrayList<>();

    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                if (value == 1) {
                    homes.add(new Node(i, j));
                } else if (value == 2) {
                    chickens.add(new Node(i, j));
                }
            }
        }

        // 폐업시키지 않을 치킨집 고르기
        boolean[] visited = new boolean[chickens.size()];

        dfs(visited, 0, 0);

        bw.write(answer + "");
        bw.close();
        br.close();
    }

    public static void dfs(boolean[] visited, int depth, int start) { // 조합이므로 로직이 중복이 된다.
        // 중복이 되지 않게 하려면 어떻게 해야할까?
        // 이미 방문한 부분은 제외해야 한다
        if (M == depth) {
            // 중복인 경우 탐색 x
            System.out.println(Arrays.toString(visited));
            calculateDistance(visited);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(visited, depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void calculateDistance(boolean[] select) {

        int cnt = 0;

        for (int i = 0; i < homes.size(); i++) {
            Node home = homes.get(i);
            int shortDistance = Integer.MAX_VALUE;
            for (int j = 0; j < chickens.size(); j++) { //집과 치킨과의 가장 짧은 거리
                if (select[j]) {
                    Node chicken = chickens.get(j);
                    int distance = Math.abs(chicken.y - home.y) + Math.abs(chicken.x - home.x);
                    shortDistance = Math.min(shortDistance, distance);
                }
            }

            cnt += shortDistance;
        }

        answer = Math.min(answer, cnt);
        return;
    }

    public static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
