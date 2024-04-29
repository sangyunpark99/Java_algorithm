package 백준.숨바꼭질5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int K;

    public static int[][] visited;
    public static final int MAX = 500_000;
    public static int turn = 1;
    public static boolean ok = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[2][MAX + 4];

        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs();
    }

    public static void bfs() { // 수빈이의 위치 이동
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        visited[0][N] = 1; // 방문 처리

        // 1초가 경과했는지 어떻게 알까?
        // bfs의 한 사이클이 돌아야 알 수 있다. 한 사이클 : cur - 1, cur + 1, 2 * cur 이 3개의 값

        while (!queue.isEmpty()) {
            K += turn; // 동생 위치
            if (K > MAX) {
                break;
            }
            if (visited[turn % 2][K] > 0) { // 수빈이가 이미 방문한 경우 - 짝수 번째, 홀수 번째
                ok = true;
                break;
            }

            int size = queue.size(); // queue에 저장된 갯수 만큼
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();

                for (int next : new int[]{cur - 1, cur + 1, 2 * cur}) {
                    if (next < 0 || next > MAX || visited[turn % 2][next] > 0) {
                        continue;
                    }
                    visited[turn % 2][next] = visited[(turn - 1) % 2][cur] + 1;

                    if (next == K) { // 이동하다가 만난 경우
                        ok = true;
                        break;
                    }

                    queue.add(next);
                }

                if (ok) {
                    break;
                }
            }

            if (ok) {
                break;
            }

            turn++;
        }

        if (ok) {
            System.out.println(turn);
            return;
        }

        System.out.println(-1);
    }
}