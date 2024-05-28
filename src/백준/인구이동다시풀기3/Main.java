package 백준.인구이동다시풀기3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, L, R;
    public static int[][] map;
    public static int[][] visited;

    public static int[] dy = {-1, 0, 1, 0};
    public static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        int result = 0;

        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        while (true) {
            if (go() == 0) { // 인구 이동이 없는 경우
                break;
            } else {
                result++;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static int go() {

        int flag = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    Queue<Node> queue = new LinkedList<>();
                    List<Node> list = new ArrayList<>();

                    queue.add(new Node(i, j));
                    list.add(new Node(i, j));

                    int sum = map[i][j];
                    visited[i][j] = 1; // 방문처리

                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int ny = cur.y + dy[k];
                            int nx = cur.x + dx[k];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                                continue;
                            }
                            if (visited[ny][nx] == 0) {
                                int gap = Math.abs(map[ny][nx] - map[cur.y][cur.x]);
                                if (L <= gap && gap <= R) {
                                    queue.add(new Node(ny, nx));
                                    list.add(new Node(ny, nx));
                                    visited[ny][nx] = 1;
                                    flag = 1; // 국경 허물 수 있다.
                                    sum += map[ny][nx];
                                }
                            }
                        }
                    }

                    if (flag > 0) {
                        int average = sum / list.size();
                        for (Node node : list) {
                            map[node.y][node.x] = average;
                        }
                    }


                }
            }
        }

        visited = new int[N][N]; // 방문 초기화

        return flag;
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
