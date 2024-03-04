package 백준.이분그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int K;
    public static int V;
    public static int E;
    public static ArrayList<Integer>[] list;
    public static boolean[] visited;
    public static boolean isCheck;
    public static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            visited = new boolean[V + 1]; // 1번 노드부터
            check = new int[V + 1];
            list = new ArrayList[V + 1];
            isCheck = true; // 테스트 케이스마다 초기화

            for (int j = 1; j <= V; j++) { // 초기화
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());

                //
                list[node1].add(node2);
                list[node2].add(node1);
            }

            for (int j = 1; j <= V; j++) {
                if (isCheck) { // 이분그래프가 아닌 경우
                    dfs(j);
                } else {
                    break;
                }
            }

            if (isCheck) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (int value : list[node]) {
            if (!visited[value]) { // 방문 안한 경우
                check[value] = (check[node] + 1) % 2; // 이전 노드와 다른 집합으로 저장
                dfs(value);
            } else if (check[node] == check[value]) { // 이미 방문한 경우
                isCheck = false;
            }
        }
    }
}
