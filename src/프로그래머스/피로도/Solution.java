package 프로그래머스.피로도;

class Solution {

    public static int answer;

    public int solution(int k, int[][] dungeons) {
        answer = -1;

        int n = dungeons.length;
        boolean[] visited = new boolean[n];
        int[] output = new int[n];

        dfs(n, 0, output, visited, dungeons, k);

        return answer;
    }

    public void dfs(int n, int depth, int[] output, boolean[] visited, int[][] dungeons, int k) {
        if (depth == n) { // 각각의 짝에 맞게

            int cnt = 0;

            for (int i = 0; i < output.length; i++) { // 탐험 가능 한지 비교
                int minTired = dungeons[output[i]][0];
                int minusTired = dungeons[output[i]][1];

                if (minTired <= k) {
                    cnt++;
                    k -= minusTired;
                } else { // 체력 안되면 나가리
                    break;
                }
            }
            answer = Math.max(answer, cnt);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                output[depth] = i;
                visited[i] = true;
                dfs(n, depth + 1, output, visited, dungeons, k);
                visited[i] = false;
            }
        }
    }

}