package 백준.RPG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int[][] a;
    public static int[][] dp;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][3];
        dp = new int[1004][1004]; // 힘, 지
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rpg(1, 1);
    }

    public static void rpg(int str, int intel) {

        int ret = 0;
        int point = 0;
        for (int i = 0; i < n; i++) {
            if (a[i][0] <= str || a[i][1] <= intel) {
                ret++;
                if (!visited[i]) {
                    visited[i] = true;
                    point += a[i][2];

                }
            }
        }
    }
}
