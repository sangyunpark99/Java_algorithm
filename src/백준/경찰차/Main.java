package 백준.경찰차;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int N, W;
    public static Point[] events; // 이벤트 발생 위치
    public static int[][] dp; // 1번 경찰차가 i번 사건을 처리했고, 2번 경찰차가 j번 사건을 처리했을때 최소 비용

    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        events = new Point[W + 1];
        dp = new int[W + 1][W + 1];

        for (int i = 1; i <= W; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            events[i] = new Point(x, y);
        }

        for (int i = 0; i <= W; i++) { // dp 초기화
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }

        sb = new StringBuilder();
        sb.append(getTotalDistance(0, 0) + "\n"); // geTotalDistance가 0이 나온다.
        getPath(0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getTotalDistance(int police1, int police2) { // 총 거리
        if (police1 == W || police2 == W) {
            return 0;
        }

        if (dp[police1][police2] != -1) {
            return dp[police1][police2];
        }

        int next = Math.max(police1, police2) + 1;

        int dist1, dist2;

        if (police1 == 0) {
            dist1 = getDistance(1, 1, events[next].x, events[next].y);
        } else {
            dist1 = getDistance(events[police1].x, events[police1].y, events[next].x, events[next].y);
        }

        if (police2 == 0) {
            dist2 = getDistance(N, N, events[next].x, events[next].y);
        } else {
            dist2 = getDistance(events[police2].x, events[police2].y, events[next].x, events[next].y);
        }

        int result1 = dist1 + getTotalDistance(next, police2);
        int result2 = dist2 + getTotalDistance(police1, next);

        return dp[police1][police2] = Math.min(result1, result2);
    }

    // 재귀 함수는 한 경우를 생각하면 된다.
    public static void getPath(int police1, int police2) { // 경로 얻기
        if (police1 == W || police2 == W) {
            return;
        }

        int next = Math.max(police1, police2) + 1;
        int dist1, dist2;

        if (police1 == 0) {
            dist1 = getDistance(1, 1, events[next].x, events[next].y);
        } else {
            dist1 = getDistance(events[police1].x, events[police1].y, events[next].x, events[next].y);
        }

        if (police2 == 0) {
            dist2 = getDistance(N, N, events[next].x, events[next].y);
        } else {
            dist2 = getDistance(events[police2].x, events[police2].y, events[next].x, events[next].y);
        }

        if (dp[next][police2] + dist1 < dp[police1][next] + dist2) {
            sb.append("1\n");
            getPath(next, police2);
        } else {
            sb.append("2\n");
            getPath(police1, next);
        }
    }

    private static int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
