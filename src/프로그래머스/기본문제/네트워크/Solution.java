package 프로그래머스.기본문제.네트워크;

import java.util.Arrays;

public class Solution {

    public static boolean[] visited;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];

        Arrays.fill(visited, false);

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(i, computers);
                answer++; // false다? 새로운 네트워크의 시작
            }
        }

        return answer;
    }

    // 서로 연결되어 있는 경우 네트워크 1추가
    public void dfs(int i, int[][] computers) {
        visited[i] = true;

        for (int j = 0; j < computers[i].length; j++) {
            if (visited[j] == false && computers[i][j] == 1) {
                dfs(j, computers);
            }
        }
    }
}
