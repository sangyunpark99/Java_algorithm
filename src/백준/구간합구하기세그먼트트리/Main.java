package 백준.구간합구하기세그먼트트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static long[] arr, tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1]; // index 1부터 시작
        tree = new long[N * 4];

        for (int i = 1; i <= N; i++) { // 배열 초기화
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, N, 1); // 세그먼트 트리 초기화
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) { // 값 업데이트
                long diff = c - arr[b]; // 이 차이만큼 다른 구간에 더해주어야 한다.
                //arr[b] = c; 굳이 필요하지 않다.
                update(1, N, 1, b, diff);
            } else { // 구간합 구하기
                sb.append(sum(1, N, 1, b, c) + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) { // 범위 내에 있는 경우
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static long init(int start, int end, int node) {
        if (start == end) { // 리프노드
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static void update(int start, int end, int node, int idx, long diff) {
        if (idx < start || idx > end) {
            return;
        }

        tree[node] += diff; // 차이만큼 더해주어야 한다.(나머지 모든 구간합에)

        if (start == end) { // 리프 노드에 도달한 경우
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, diff);
        update(mid + 1, end, node * 2 + 1, idx, diff);
    }
}
