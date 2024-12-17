package 프로그래머스.부대복귀;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private List<List<Integer>> graph = new ArrayList<>();

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        // 한 노드에서 다른 노드로 가는 길의 최단 거리
        for (int i = 0; i < n + 1; i++) { // 1부터시작
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];

            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        int idx = 0;

        for (int source : sources) {
            answer[idx] = bfs(graph, source, destination, n);
            idx++;
        }

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public int bfs(List<List<Integer>> graph, int start, int destination, int n) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        int[] visited = new int[n + 1]; // 한번 방문한 노드는 재방문 x
        visited[start] = 1;

        boolean flag = false;
        while (!queue.isEmpty() && !flag) {
            int curNode = queue.poll();

            for (int value : graph.get(curNode)) {
                if (visited[value] == 0) { // 방문하지 않은 경우
                    visited[value] += visited[curNode] + 1;
                    queue.add(value);
                }

                if (value == destination) {
                    flag = true;
                    break;
                }
            }
        }

        return visited[destination] - 1;
    }
}
