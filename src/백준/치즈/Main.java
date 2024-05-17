package 백준.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static int[][] map;
    public static int[][] visited;

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 치즈에 구멍을 어떻게 구분하지?
        // 어떻게 구분하지~?

        int cnt = 0;
        ArrayList<Integer> size = new ArrayList<>();
        while (!check()) {
            size.add(checkCheeseSize());
            cnt++;
            dfs(0, 0);
            clearCheese();
            visited = new int[n][m];
        }

        System.out.println(cnt);
        System.out.println(size.get(size.size() - 1)); // 마지막 사이즈
    }

    public static boolean check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void clearCheese() {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int y = cur.y;
            int x = cur.x;

            map[y][x] = 0; // 치즈 녹이기
        }
    }

    public static int checkCheeseSize() {

        int size = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    size++;
                }
            }
        }

        return size;
    }

    public static void dfs(int y, int x) {
        visited[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= m || visited[ny][nx] != 0) {
                continue;
            }
            if (map[ny][nx] != 1) {
                dfs(ny, nx);
            } else { // 1인경우 치즈이므로 넣어주기
                queue.add(new Node(ny, nx)); // 치즈를 지우기
            }
        }
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
