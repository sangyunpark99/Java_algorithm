package 백준.최솟값찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> dq = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        // index가 0부터 시작

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 자체 정렬 과정
            while (!dq.isEmpty() && dq.getLast().value > now) { // 마지막 값의 value가 now보다 큰 경우
                dq.removeLast();
            }

            dq.addLast(new Node(i, now));

            // 범위에서 벗어난 값 덱에서 제거
            if (dq.getFirst().idx <= i - L) {
                dq.removeFirst();
            }

            bw.write(dq.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
