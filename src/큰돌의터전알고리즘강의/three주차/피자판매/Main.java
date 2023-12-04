package 큰돌의터전알고리즘강의.three주차.피자판매;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static int size;
    public static int M;
    public static int N;
    public static int[] a = new int[1001]; // 원형태의 자료구조는 선형으로 변경해서 푼다.
    public static int[] b = new int[1001];
    public static int[] psum_a = new int[2002];
    public static int[] psum_b = new int[2002];
    public static Map<Integer, Integer> aCnt = new HashMap<>();
    public static Map<Integer, Integer> bCnt = new HashMap<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= M; i++) {
            int value = Integer.parseInt(br.readLine());
            a[i] = value;
            psum_a[i] = psum_a[i - 1] + a[i];
        }

        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(br.readLine());
            b[i] = value;
            psum_b[i] = psum_b[i - 1] + b[i];
        }

        //make(psum_a, M, aCnt);
        //make(psum_b, N, bCnt);

        //System.out.println(aCnt);
        //System.out.println(bCnt);
    }

    public static void make(int[] pSum, int n, Map<Integer, Integer> map) {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= n; j++) {
                if (j < i) {
                    continue;
                }
                int sum = pSum[j] - pSum[j - i];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
    }
}
