package 백준.숨바꼭질2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final int MAX = 100_000;
    public static int N, K, time, res;

    public static int[] visited;
    public static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[MAX + 1];
        cnt = new int[MAX + 1];

        cnt[N] = 1;
        visited[N] = 1;

        if (N == K) {
            sb = new StringBuilder();
            sb.append(0 + "\n");
            sb.append(1);
            bw.write(sb.toString());
            bw.close();
            br.close();
            return;
        }

        bfs();

        sb = new StringBuilder();
        sb.append(visited[K] - 1 + "\n");
        sb.append(cnt[K] + "\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    // 가장 빠른 : BFS
    public static void bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int value : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (value < 0 || value > MAX) {
                    continue;
                }

                if (visited[value] == 0) { // 한번도 방문하지 않은 경우
                    visited[value] = visited[cur] + 1; // time 추가
                    queue.offer(value);
                    cnt[value] += cnt[cur]; // value나올때까지의 횟수 추가
                } else if (visited[value] == visited[cur] + 1) { // 방문을 했는데 가장 빠른 경우인 경우
                    cnt[value] += cnt[cur];
                }
            }
        }
    }
}