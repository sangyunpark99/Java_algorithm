package 백준.친구관계파악하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static boolean[] visited;
    public static boolean arrive;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arrive = false;

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
        }

        if (arrive) {
            System.out.println(1);
            return;
        }

        System.out.println(0);
    }

    public static void dfs(int v, int depth) {

        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        visited[v] = true;

        for (int i : list.get(v)) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }

        visited[v] = false;
    }
}
