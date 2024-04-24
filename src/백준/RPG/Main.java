package 백준.RPG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int[][] q;
    public static int[][] dp; // 능력치가 i, j일때 최대 퀘스트 수행 개수
    public static boolean[] visited; // 했던 퀘스트인지 확인하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 0 : 힘, 1 : 지략, 2 : 포인트
        q = new int[51][3];
        dp = new int[1001][1001];

        for (int i = 0; i < 1001; i++) { // -1로 채우기
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                q[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }

    public static int cal(int a, int b) {
        if (dp[a][b] != -1) {
            return dp[a][b];
        }

        int point = 0;
        dp[a][b] = 0;

        ArrayList<Integer> visitIndex = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (q[i][0] <= a || q[i][1] <= b) {
                dp[a][b] += 1;

                if (visited[i]) {
                    continue; // 퀘스트
                }

                point += q[i][2];
                visited[i] = true;

                visitIndex.add(i);
            }
        }

//        for (int i = 0; i <= point; i++) {
//            dp[a][b] =
//        }

        return 1;
    }
}
