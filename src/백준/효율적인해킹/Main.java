package 백준.효율적인해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static boolean[] visited;
    public static int[] answer;
    public static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A[S].add(E);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            bfs(i);
        }

        int maxVal = Integer.MIN_VALUE;

        for (int i = 1; i < answer.length; i++) {
            maxVal = Math.max(maxVal, answer[i]);
        }

        System.out.println(Arrays.toString(answer));

        for (int i = 1; i <= N; i++) {
            if (answer[i] == maxVal) {
                System.out.print(i + " ");
            }
        }

        br.close();
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : A[cur]) {
                if (visited[i] == false) {
                    visited[i] = true;
                    answer[i]++; // 신규노드 인덱스 배열 증가
                    queue.add(i);
                }
            }
        }
    }
}
