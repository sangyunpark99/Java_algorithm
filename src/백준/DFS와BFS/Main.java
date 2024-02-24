package 백준.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int V;
    public static boolean[] visited;

    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static StringBuilder dfsSb;
    public static StringBuilder bfsSb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(list.get(i));
        }

        dfsSb = new StringBuilder();
        bfsSb = new StringBuilder();

        visited = new boolean[N + 1];

        dfs(V);

        visited = new boolean[N + 1];

        bfs(V);

        System.out.println(dfsSb);
        System.out.println(bfsSb);
    }

    public static void dfs(int start) {

        visited[start] = true;
        dfsSb.append(start + " ");

        for (int i : list.get(start)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            bfsSb.append(v + " ");
            for (int i : list.get(v)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
