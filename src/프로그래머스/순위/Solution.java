package 프로그래머스.순위;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[][]{
                {4, 3},
                {4, 2},
                {3, 2},
                {1, 2},
                {2, 5}
        }));
    }

    public static int solution(int n, int[][] results) { // 간접 승리 -> 그래프 탐색
        int answer = 0;

        // 1 ~ n 번
        List<List<Integer>> winnerList = new ArrayList<>(); // i를 이긴 사람
        List<List<Integer>> loseList = new ArrayList<>(); // i에게 진 사람

        for (int i = 0; i <= n; i++) {
            winnerList.add(new ArrayList<>());
            loseList.add(new ArrayList<>());
        }

        for (int[] result : results) {
            int win = result[0]; // 이긴 사람
            int lose = result[1]; // 진 사람

            winnerList.get(lose).add(win);
            loseList.get(win).add(lose);
        }

        // 각 번호별로 그래프를 탐색
        for (int i = 1; i <= n; i++) { // O(n) -> 100
            int winnerCount = bfs(i, winnerList, n);
            int loseCount = bfs(i, loseList, n);

            if (winnerCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    public static int bfs(int start, List<List<Integer>> list, int n) { //
        int count = 0;
        boolean[] visited = new boolean[n + 1]; // 1번부터 n번 노드까지
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int value : list.get(cur)) {
                if (!visited[value]) { // 재방문 방지
                    visited[value] = true;
                    queue.add(value);
                    count++;
                }
            }
        }

        return count;
    }
}
