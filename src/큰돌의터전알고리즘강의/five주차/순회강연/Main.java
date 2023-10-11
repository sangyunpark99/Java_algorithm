package 큰돌의터전알고리즘강의.five주차.순회강연;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        int answer = 0; // 정답
        List<a> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new a(p,d));
        }

        list.sort(new Comparator<a>() {
            @Override
            public int compare(a o1, a o2) {
                return o1.d - o2.d;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < list.size(); i++) {

            pq.add(list.get(i).p);

            if(pq.size() > list.get(i).d){
                pq.poll(); // 최솟값 제거
            }
        }

        int size = pq.size();

        for (int i = 0; i < size; i++) {
            answer += pq.poll();
        }

        System.out.println(answer);
    }

    public static class a {
        int d = 0;
        int p = 0;
        public a(int p, int d){
            this.d = d;
            this.p = p;
        }
    }
}
