package 백준.구간합구하기세그먼트트리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static long[] arr;
    public static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        // 트리의 노드는 1번부터 시작
        init(1, N, 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { // 수 변경
                long dif = c - arr[b]; // 변경된 수가 또 변경될 수 있다.
                arr[b] = c;
                update(1, N, 1, b, dif);
            } else if (a == 2) { // 구간의 합 구하기
                sb.append(sum(1, N, 1, b, (int) c) + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static long init(int start, int end, int node) {
        if (start == end) { // 리프 노드
            return tree[node] = arr[start];
        }

        // 분할해서
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    // 재귀 함수는 종료조건이 분명해야 한다.
    public static void update(int start, int end, int node, int idx, long dif) {
        if (idx < start || idx > end) { // 인덱스가 범위를 벗어난 경우
            return;
        }
        tree[node] += dif;

        if (start == end) { // 리프 노드인 경우
            return;
        }

        // 다른 구간도 업데이트
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, dif);
        update(mid + 1, end, node * 2 + 1, idx, dif);
    }

    public static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) { // 구간을 벗어난 경우
            return 0;
        }

        if (left <= start && end <= right) { // 구간이 겹치거나 내부에 존재하는 경우
            return tree[node];
        }

        // 겹치지 않는 부분이 생기는 경우 => 겹치지 않은 부분에 대한 합을 구해준다.
        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }
}