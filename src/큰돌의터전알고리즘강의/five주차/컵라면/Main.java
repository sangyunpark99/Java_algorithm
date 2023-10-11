package 큰돌의터전알고리즘강의.five주차.컵라면;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<A> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new A(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        // 일자순으로 정렬
        list.sort(new Comparator<A>() {
            @Override
            public int compare(A o1, A o2) {
                return o1.deadLine - o2.deadLine;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < list.size(); i++) {

            pq.add(list.get(i).ramanNum);

            if(pq.size() >
                    list.get(i).deadLine){ // 필요 없는 값제외
                pq.poll();
            }
        }

        int answer = 0;
        int size = pq.size();

        for (int i = 0; i < size; i++) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }

    static class A {
        int deadLine;
        int ramanNum;

        public A(int deadLine, int ramanNum){
            this.deadLine = deadLine;
            this.ramanNum = ramanNum;
        }
    }
}
