package 프로그래머스.정수삼각형;

public class Main {

    public static boolean[][] visited;
    public static int tmp = Integer.MIN_VALUE;
    public static int depth;

    public static void main(String[] args) {

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        visited = new boolean[501][501];

        // 완전 탐색? >> dfs 오른쪽 or 왼쪽
        depth = triangle.length;
        System.out.println(depth);

        dfs(0, 0, triangle, 0);

        System.out.println(tmp);
    }

    public static void dfs(int cnt, int sum, int[][] triangle, int i) {
        if (cnt == depth) { // 깊이
            tmp = Math.max(tmp, sum);
            return;
        }

        dfs(cnt + 1, sum + triangle[cnt][i], triangle, i);
        dfs(cnt + 1, sum + triangle[cnt][i], triangle, i + 1);
    }
}
