package 백준.인구이동다시풀기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int L;
    public static int R;

    public static int[][] map;
    public static int[][] visited;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int result = 0;

        while (true) { // 인구 이동이 없을 때까지
            if (move() == 0) { // 이동이 없다면
                break;
            } else {
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int move() {
        int flag = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (visited[y][x] == 0) {
                    Queue<Node> queue = new LinkedList<>();
                    ArrayList<Node> list = new ArrayList<>();

                    Node node = new Node(y, x);
                    queue.add(node);
                    list.add(node);

                    int sum = map[node.y][node.x]; // 합계
                    visited[node.y][node.x] = 1;

                    while (!queue.isEmpty()) {
                        Node cur = queue.poll();

                        for (int i = 0; i < 4; i++) {
                            int nx = cur.x + dx[i];
                            int ny = cur.y + dy[i];

                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                                continue;
                            }
                            if (visited[ny][nx] == 0) { // 방문 x
                                int gap = Math.abs(map[ny][nx] - map[cur.y][cur.x]);
                                if (gap >= L && gap <= R) {
                                    queue.add(new Node(ny, nx));
                                    list.add(new Node(ny, nx));
                                    visited[ny][nx] = 1;
                                    flag = 1;
                                    sum += map[ny][nx];
                                }
                            }
                        }
                    }

                    if (flag > 0) { // 분할이 된 경우
                        int average = sum / list.size();
                        for (int k = 0; k < list.size(); k++) {
                            Node cur = list.get(k);
                            map[cur.y][cur.x] = average;
                        }
                    }
                }
            }
        }

        visited = new int[N][N];
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