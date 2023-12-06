package 큰돌의터전알고리즘강의.three주차.선긋기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long first = Long.parseLong(st.nextToken());
            long second = Long.parseLong(st.nextToken());

            list.add(new Node(first, second));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int) o1.start - (int) o2.start;
            }
        });

        int ret = 0;
        long start = list.get(0).start;
        long end = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            Node cur = list.get(i);

            if (end < cur.start) { // 겹치지않는 경우
                ret += end - start;
                start = list.get(i).start;
                end = list.get(i).end;
            } else if (cur.start <= end && cur.end >= end) { // 겹치는 경우
                end = list.get(i).end;
            }
        }

        ret += end - start;

        System.out.println(ret);
    }

    public static class Node {
        long start;
        long end;

        public Node(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
