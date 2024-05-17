package 백준.효율적인해킹복습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static List<Integer>[] list;
    public static int[] visited;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N];
        result = new int[N];

        list = new ArrayList[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;

            // 양방향 연관관계
            list[A].add(B);
        }

        for (int i = 0; i < N; i++) {
            visited = new int[N];
            bfs(i);
        }

        int maxCnt = -1; // 한번에 해킹할 수 있는 갯수

        for (int i = 0; i < N; i++) {
            maxCnt = Math.max(maxCnt, result[i]);
        }

        for (int i = 0; i < N; i++) {
            if (result[i] == maxCnt) {
                bw.write(i + 1 + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int here = queue.poll();
            for (int value : list[here]) {
                if (visited[value] != 1) {
                    visited[value] = 1;
                    queue.add(value);
                    result[value]++; // value가 해킹할 수 있는 숫자 증가
                }
            }
        }
    }
}
