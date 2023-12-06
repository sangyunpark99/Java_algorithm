package 큰돌의터전알고리즘강의.three주차.원판돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int T;
    public static int x;
    public static int d;
    public static int k;
    public static int flag;
    public static boolean[][] visited;
    public static List<List<Integer>> list = new ArrayList<>();
    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> value = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                value.add(Integer.parseInt(st.nextToken()));
            }
            list.add(value);
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int j = x - 1; j < N; j += x) { // x 배수만큼 로테이트
                rotate(j, d, k);
            }

            if (findAdj()) {
                setAverage();
            }
        }

        int ret = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                ret += list.get(i).get(j);
            }
        }

        System.out.println(ret);

    }

    public static boolean findAdj() {

        flag = 1;

        visited = new boolean[N][M]; // 인접을 나타내는 visited 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (list.get(i).get(j).equals(0)) {
                    continue;
                }
                if (visited[i][j]) { //
                    continue;
                }
                dfs(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    list.get(i).set(j, 0);
                }
            }
        }

        if (flag == 0) {
            return false;
        }

        return true;
    }

    public static void setAverage() {
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (list.get(i).get(j).equals(0)) {
                    continue;
                }
                sum += list.get(i).get(j);
                cnt++;
            }
        }

        double avg = (double) sum / (double) cnt;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                double value = list.get(i).get(j);
                if (value > 0) {
                    if (avg > value) {
                        list.get(i).set(j, (int) value + 1);
                    } else if (avg < value) {
                        list.get(i).set(j, (int) value - 1);
                    }
                }
            }
        }
    }

    static void dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i]; // 북,남
            int nx = (x + dx[i] + M) % M;

            if (ny < 0 || ny >= N) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            if (list.get(ny).get(nx).equals(list.get(y).get(x))) {
                visited[y][x] = visited[ny][nx] = true;
                flag = 0;
                dfs(ny, nx); // 계속해서 탐색
            }
        }
    }

    public static void rotate(int y, int dir, int k) {

        List<Integer> value = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            value.add(list.get(y).get(i));
        }

        for (int j = 0; j < k; j++) {
            if (dir == 1) {
                Collections.rotate(value, -1); // 시계 방향
            } else {
                Collections.rotate(value, 1); // 반시계 방향
            }
        }

        list.set(y, value);
    }
}