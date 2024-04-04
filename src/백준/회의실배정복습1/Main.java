package 백준.회의실배정복습1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Node node = new Node(start, end);
            list.add(node);
        }

        Collections.sort(list);

        int ret = 1;
        int end = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start >= end) {
                ret++;
                end = list.get(i).end;
            }
        }

        bw.write(ret + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {

            if (this.end == o.end) {
                return this.start - o.start;
            }

            return this.end - o.end;
        }
    }
}
