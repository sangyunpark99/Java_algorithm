package 큰돌의터전알고리즘강의.three주차.피자판매;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static int size;
    public static int M;
    public static int N;
    public static int[] a = new int[1001]; // 원형태의 자료구조는 선형으로 변경해서 푼다.
    public static int[] b = new int[1001];
    public static int[] psum_a = new int[2002];
    public static int[] psum_b = new int[2002];
    public static HashMap<Integer, Integer> aCnt = new HashMap<>();
    public static HashMap<Integer, Integer> bCnt = new HashMap<>();
    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        aCnt = new HashMap<>();
        bCnt = new HashMap<>();

        for (int i = 1; i <= 1000_000; i++) { // 초기화
            aCnt.put(i, 0);
            bCnt.put(i, 0);
        }

        for (int i = 1; i <= M; i++) { // 누적합은 1부터
            int value = Integer.parseInt(br.readLine());
            a[i] = value;
            psum_a[i] = psum_a[i - 1] + a[i];
        }

        for (int i = M + 1; i <= 2 * M; i++) { // 원형 선형으로 변경
            psum_a[i] = psum_a[i - 1] + a[i - M];
        }

        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(br.readLine());
            b[i] = value;
            psum_b[i] = psum_b[i - 1] + b[i];
        }

        for (int i = N + 1; i <= 2 * N; i++) {
            psum_b[i] = psum_b[i - 1] + b[i - N];
        }

        make(M, psum_a, aCnt);
        make(N, psum_b, bCnt);

        answer = aCnt.get(size) + bCnt.get(size); // A피자, B피자 따로보는 경우
        for (int i = 1; i < size; i++) { // A피자, B피자 같이 보는 경우
            answer += (aCnt.get(i) * bCnt.get(size - i)); // O(1)
        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static void make(int n, int[] psum, HashMap<Integer, Integer> map) { // 각 범위마다
        for (int interval = 1; interval <= n; interval++) {
            for (int start = interval; start <= n + interval - 1; start++) {
                int sum = psum[start] - psum[start - interval];
                map.put(sum, map.get(size) + 1);

                if (interval == n) { // 길이가 1인 부분수열 1개
                    break;
                }
            }
        }
    }

}