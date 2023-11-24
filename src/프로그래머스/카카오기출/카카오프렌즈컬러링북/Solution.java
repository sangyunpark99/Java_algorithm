package 프로그래머스.카카오기출.카카오프렌즈컬러링북;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                maxSizeOfOneArea = Math.max(bfs(i, j, visited, m, n, picture), maxSizeOfOneArea);
                numberOfArea++;
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    public int bfs(int y, int x, boolean[][] visited, int m, int n, int[][] pictrue) {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int curValue = pictrue[y][x];

        int count = 1; // 시작 점
        visited[y][x] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            int curX = curNode.x;
            int curY = curNode.y;

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (!visited[ny][nx] && pictrue[ny][nx] == curValue) {
                    visited[ny][nx] = true;
                    queue.add(new Node(ny, nx));
                    count++;
                }
            }
        }
        return count;
    }

    class Node {
        int x;
        int y;

        Node(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

}
