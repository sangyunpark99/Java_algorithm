package 백준.트리의지름구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static ArrayList<ArrayList<Node>> list;
    public static int[] distance;
    public static boolean[] visited;

    public static class Node {
        int e;
        int value;

        public Node(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) { // list 초기화
            list.add(i, new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            while (true) {
                int nextNode = Integer.parseInt(st.nextToken());
                if (nextNode == -1) {
                    break;
                }
                int distance = Integer.parseInt(st.nextToken());
                Node node = new Node(nextNode, distance);
                list.get(nodeNum).add(node);
            }
        }

        bfs(1); // 첫번째 노드부터 시작

        int maxNode = 1;

        for (int i = 2; i <= N; i++) {
            if (distance[maxNode] < distance[i]) {
                maxNode = i;
            }
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];

        bfs(maxNode); // 5번노드에서 시작

        Arrays.sort(distance);

        System.out.println(distance[N]);
    }

    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for (Node node : list.get(nowNode)) {
                int e = node.e;
                int value = node.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[nowNode] + value;
                }
            }
        }
    }
}
