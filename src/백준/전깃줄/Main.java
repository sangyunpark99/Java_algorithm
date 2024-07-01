package 백준.전깃줄;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static int N;

    public static int[] dp;

    public static int[][] line;

    public static void main(String[] args) throws IOException {
        // 제일 많이 교차하는 친구를 찾는다.
        // 없앤다.
        // 제일 많이 교차하는 친구의 기준 : 구간 사이에 숫자가 많은 경우
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new int[N];
        line = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Integer.parseInt(st.nextToken());
            line[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        System.out.println(Arrays.deepToString(line));

        // LIS 최장 증가 부분 수열 알고리즘
        for(int i = 0; i < )
    }
}
