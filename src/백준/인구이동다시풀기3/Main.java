package 백준.인구이동다시풀기3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
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

        map = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        bw.write(go() + "\n");
        br.close();
        bw.close();
    }

    public static int go() {

        int answer = 0;

        while (true) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(0, 0)); // (0,0)을 시작점으로
            visited = new int[N][N]; // 방문
            Queue<Node> country = new LinkedList<>();
            int sum = 0;
            while (!queue.isEmpty()) { // 다 탐색해야 한다.
                System.out.println("queue : " + queue);
                Node cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= N) {
                        continue;
                    }

                    if (visited[ny][nx] == 0) { // 국경이 열릴 경우 추가
                        int gap = Math.abs(map[ny][nx] - map[cur.y][cur.x]);
                        if (L <= gap && gap <= R) {
                            sum += map[ny][nx]; // 합계
                            country.add(new Node(ny, nx));
                        }
                        visited[ny][nx] = 1; // 방문 처리
                        queue.add(new Node(ny, nx)); // 다음 방문 처리
                    }
                }
            }

            if (country.isEmpty()) { // 비어있는 경우
                break;
            }

            // 비어있지 않다면
            int value = sum / country.size();
            for (Node node : country) { // 국경에 값 부여하기
                map[node.y][node.x] = value;
            }

            answer++;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println();
        }

        return answer;
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
