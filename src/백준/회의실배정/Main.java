package 백준.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Node[] value = new Node[N];

        // 끝 시간을 기준으로 정렬하기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            value[i] = new Node(start, end);
        }

        Arrays.sort(value, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                if (o1.end == o2.end) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        int answer = 1;
        int beforeEnd = value[0].end;
        for (int i = 1; i < value.length; i++) {
            Node cur = value[i];
            int curEnd = cur.end;
            int curStart = cur.start;

            if (beforeEnd <= curStart) {
                answer++;
                beforeEnd = curEnd;
            }
        }

        System.out.println(answer);
    }
}
