package 백준.자두나무DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int T;
    public static int W;
    public static int[] zadu;
    public static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        zadu = new int[1004]; // 1초부터 시작

        for (int i = 0; i < T; i++) {
            zadu[i] = Integer.parseInt(br.readLine());
        }
    }
}
