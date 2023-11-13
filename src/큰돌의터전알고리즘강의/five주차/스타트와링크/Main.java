package 큰돌의터전알고리즘강의.five주차.스타트와링크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] map;
    private static int min = Integer.MAX_VALUE;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);

        System.out.println(min);
    }

    private static void backTracking(int idx, int depth) {
        if (depth == n / 2) { // 2가지를 짝지은 경우, 나머지 n/2는 알아서 짝이 됨
            diff();
            return;
        }

        for (int i = idx; i < n; i++) {// 방문하지 않은 경우
            visit[i] = true; // 방문처리
            backTracking(i + 1, depth + 1);
            visit[i] = false; // 방문하고 값 처리 했으니 다시 취소
        }
    }

    private static void diff() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) { // 한쌍의 처음부분은 최대가 n-2까지
            for (int j = i + 1; j < n; j++) { // 한쌍의 마지막 부분은 n-1까지
                if (visit[i] && visit[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if (!visit[i] && !visit[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int res = Math.abs(start - link);
        min = Math.min(res, min);
    }

}
