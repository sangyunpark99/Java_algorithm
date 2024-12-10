package 프로그래머스.가장먼노드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private static boolean[] visited;
    private static List<List<Integer>> graph;
    private static List<List<Integer>> depthPerNode = new ArrayList<>();

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        graph = new ArrayList<>();

        visited = new boolean[n + 1]; // 방문 처리

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) { // 양방향 간선
            int[] values = edge[i];
            graph.get(values[0]).add(values[1]);
            graph.get(values[1]).add(values[0]);
        }

        answer = bfs();

        return answer;
    }

    public static int bfs() { // 전부 탐색
        visited[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        int depth = 0;
        queue.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depthPerNode.add(new ArrayList<>()); // 0번 부터 시작
            for (int i = 0; i < size; i++) {
                int curNode = queue.poll();
                depthPerNode.get(depth).add(curNode);

                for (int value : graph.get(curNode)) {
                    if (!visited[value]) {
                        visited[value] = true;
                        queue.add(value);
                    }
                }
            }
            depth++;
        }

        return depthPerNode.get(depth - 1).size();
    }

    public static void main(String[] args) {
        int[][] vertex = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}
        };

        System.out.println(solution(6, vertex));
    }
}
