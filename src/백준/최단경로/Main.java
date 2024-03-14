package 백준.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 100_000_000;
    public static int V;
    public static int E;
    public static int K;

    public static ArrayList<Node>[] graph;
    public static int[] dist;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, INF); // INF로 채워넣기

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(K);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i] + "\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0)); // 가중치가 0인 node 추가
        dist[start] = 0; // 시작 거리 0 으로 추가

        while (!pq.isEmpty()) {
            Node curNode = pq.poll(); // 가중치를 기반으로 제일 가중치가 작은 값을 내보낸다.

            if (visited[curNode.end]) { // 이미 방문한 경우 continue
                continue;
            }

            visited[curNode.end] = true; // 방문 처리 해주고

            // 방문을 안했다면?
            for (Node node : graph[curNode.end]) { // 거리 가중치 업데이트
                if (dist[node.end] > dist[curNode.end] + node.weight) {
                    dist[node.end] = dist[curNode.end] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {

        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
