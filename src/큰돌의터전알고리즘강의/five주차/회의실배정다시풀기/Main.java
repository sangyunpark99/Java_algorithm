package 큰돌의터전알고리즘강의.five주차.회의실배정다시풀기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            list.add(new Node(startTime,endTime));
        }

        // 정렬 -> 끝나는 시간으로 정렬
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {

                if(o1.endTime == o2.endTime){
                    return o1.startTime - o2.startTime;
                }

                return o1.endTime - o2.endTime;
            }
        });

        int res = 1;
        int beforeTime = list.get(0).endTime;
        for (int i = 1; i < list.size(); i++) {
            int curStartTime = list.get(i).startTime;

            if(beforeTime <= curStartTime){
                res++;
                beforeTime = list.get(i).endTime;
            }
        }

        System.out.println(res);
    }

    public static class Node {
        int startTime;
        int endTime;

        public Node(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
