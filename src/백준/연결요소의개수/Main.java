package 백준.연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1]; // 1부터 시작

        list = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            list.get(node1).add(node2);
            list.get(node2).add(node1);
        }

        int answer = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }

    public static void dfs(int v) {
        if (visited[v]) { // 방문한 노드인 경우 return -> 연결된 노드끼리는 방문을 완료했다.
            return;
        }

        visited[v] = true; // 방문 처리 완료
        for (int i : list.get(v)) {
            dfs(i); // 방문 시키기
        }
    }
}
