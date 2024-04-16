package 백준.순회강연;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(p, d);
        }

        int res = 0;

        Arrays.sort(nodes);

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.p - o2.p;
            }
        });

        for (int i = 0; i < nodes.length; i++) { // 최솟값 제거
            Node node = nodes[i];

            pq.add(node);

            if (pq.size() > node.d) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            res += pq.poll().p;
        }

        bw.write(res + "\n");
        bw.close();
        br.close();
    }

    public static class Node implements Comparable<Node> { // 객체 자체에 정렬기준을 부여한다.
        int p;
        int d;

        public Node(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }
}