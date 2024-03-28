package 백준.컵라면다시풀기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static List<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.add(new Node(deadline, value));
        }

        // 구간 -> 라인 스위핑
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.deadline - o2.deadline;
            }
        }); // 정렬

        PriorityQueue<Node> pq = new PriorityQueue<>();

        int answer = 0;

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            answer += node.value;
            pq.add(node);
            if (pq.size() > node.deadline) {
                answer -= pq.poll().value;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    public static class Node implements Comparable<Node> {

        int deadline;
        int value;

        public Node(int deadline, int value) {
            this.deadline = deadline;
            this.value = value;
        }

        @Override
        public int compareTo(Node node) {
            return this.value - node.value;
        }
    }
}
