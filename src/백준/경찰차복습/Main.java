package 백준.경찰차복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int w;
    private static int[] px = new int[1003];
    private static int[] py = new int[1003];
    private static int[][] dp = new int[1003][1003];

    // 경찰차 위치와 사건의 위치를 다 한 배열에 담는다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());

        // 첫번째 경찰차 (1,1)에서 시작
        px[0] = 1;
        py[0] = 1;

        // 두번째 경찰차 (n,n)에서 시작
        px[1] = n;
        py[1] = n;

        for (int i = 2; i < w + 2; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            py[i] = y;
            px[i] = x;
        }

        System.out.println(getTotalDistance(0, 1)); // 사건 번호는 2번부터
        trackPath();
    }

    // 총 거리 구하기 Top -> Bottom
    // dp[0][1]에 최댓값이 들어가 있다.
    private static int getTotalDistance(int a, int b) { // 1번 경찰자, 2번 경찰차
        if (a == w + 1 || b == w + 1) { // 이미 모든 경우를 탐색한 경우
            return 0;
        }

        if (dp[a][b] != 0) {
            return dp[a][b];
        }

        int next = Math.max(a, b) + 1; // 다음 사건의 번호 유추하기 위함

        // 경찰차 1이 해결한 경우, 경찰차 2가 해결한 경우
        return dp[a][b] = Math.min(getTotalDistance(a, next) + getDistance(b, next),
                getTotalDistance(next, b) + getDistance(a, next));
    }

    private static void trackPath() { // 경로 추적 방식 -> 사건 하나씩 다시 탐색 비교(dp로)
        // dp에는 이미 전부 최솟값이 반영
        int a = 0;
        int b = 1;
        for (int i = 2; i < w + 2; i++) { // 사건 번호를 2부터 시작
            if (dp[i][b] + getDistance(a, i) < dp[a][i] + getDistance(b, i)) { // a가 사건을 처리한 경우
                System.out.println("1");
                a = i; // 위치 옮기기
            } else {
                System.out.println("2");
                b = i; //
            }
        }
    }

    private static int getDistance(int a, int b) { // 거리 구하기
        return Math.abs(px[a] - px[b]) + Math.abs(py[a] - py[b]);
    }
}