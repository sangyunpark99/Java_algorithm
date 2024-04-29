package 백준.숨바꼭질5다시풀기;

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
    public static int turn = 1; // 시작할때 1턴 이미 진행중
    public static boolean ok = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[2][MAX + 1]; // 최대 500,000 까지

        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs();
    }

    public static void bfs() {

        visited[0][N] = 1; // 방문 처리

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            K += turn;
            int size = queue.size();
            if (K > MAX) {
                break;
            }

            if (visited[turn % 2][K] > 0) { // 수빈이가 이미 (짝수,홀수)턴에 이미 방문한 경우
                ok = true;
                break;
            }

            for (int i = 0; i < size; i++) { // 한 계층
                int cur = queue.poll();
                for (int next : new int[]{cur - 1, cur + 1, 2 * cur}) {
                    if (next < 0 || next > MAX || visited[turn % 2][next] != 0) { // 이미 방문한 경우
                        continue;
                    }
                    visited[turn % 2][next] = visited[(turn - 1) % 2][cur] + 1;

                    if (next == K) { // 이동하다가 만나는 경우
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
