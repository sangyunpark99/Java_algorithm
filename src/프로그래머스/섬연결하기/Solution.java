package 프로그래머스.섬연결하기;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{
                {0, 1, 1},
                {0, 2, 2},
                {1, 2, 5},
                {1, 3, 1},
                {2, 3, 8}
        }));
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;

        List<List<Bridge>> nodes = new ArrayList<>();

        for (int i = 0; i < n; i++) { // 노드 갯수 별로
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            int firstNode = cost[0];
            int secondNode = cost[1];
            int weight = cost[2];

            nodes.get(firstNode).add(new Bridge(secondNode, weight));
            nodes.get(secondNode).add(new Bridge(firstNode, weight));
        } // 양방향 그래프

        boolean[] visited = new boolean[n];

        // 우선순위 큐를 사용해서 가중치가 제일 작은 걸 선택
        PriorityQueue<Bridge> pq = new PriorityQueue<>(Comparator.comparingInt(bridge -> bridge.weight));
        pq.add(new Bridge(0, 0));

        while (!pq.isEmpty()) {
            Bridge cur = pq.poll(); // 주어진 간선의 최솟값
            if (visited[cur.nodeNum]) {
                continue;
            }

            visited[cur.nodeNum] = true;
            answer += cur.weight;

            for (Bridge bridge : nodes.get(cur.nodeNum)) { // 다음 노드에 이어지는 간선 추가
                if (!visited[bridge.nodeNum]) {
                    pq.add(bridge); // 모든 간선을 연결
                }
            }
        }

        return answer;
    }

    static class Bridge {
        int nodeNum;
        int weight;

        public Bridge(int nodeNum, int weight) {
            this.nodeNum = nodeNum;
            this.weight = weight;
        }
    }
}
