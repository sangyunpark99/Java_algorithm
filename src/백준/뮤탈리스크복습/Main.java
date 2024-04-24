package 백준.뮤탈리스크복습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[] scvs;
    public static int answer;

    // 공격하는 방식
    public static int[][] attack = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
    };

    public static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        scvs = new int[N];
        answer = Integer.MAX_VALUE;

        dp = new int[61][61][61]; // SCV의 최대 체력은 60

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scvs[i] = Integer.parseInt(st.nextToken());
        }

        dfs(scvs, 0);

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    public static void dfs(int[] scvs, int cnt) {

        int scv1 = scvs[0];
        int scv2 = scvs[1];
        int scv3 = scvs[2];

        // 공격 횟수 최솟값 보다 현재 공격 횟수가 같거나 클 경우 멈추기
        if (answer <= cnt) {
            return;
        }

        // 이미 방문했는데 기존 공격 횟수가 더 작은 경우 중단
        if (dp[scv1][scv2][scv3] != 0 && dp[scv1][scv2][scv3] <= cnt) {
            return;
        }

        dp[scv1][scv2][scv3] = cnt;

        if (scv1 == 0 && scv2 == 0 && scv3 == 0) { // 전부다 죽은 경우
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = 0; i < attack.length; i++) {
            dfs(new int[]{Math.max(scv1 - attack[i][0], 0), Math.max(scv2 - attack[i][1], 0),
                    Math.max(scv3 - attack[i][2], 0)}, cnt + 1);
        }
    }
}
