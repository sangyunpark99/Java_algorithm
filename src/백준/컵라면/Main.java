package 백준.컵라면;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static ArrayList<CupRamen> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            list.add(new CupRamen(deadline, number));
        }

        Collections.sort(list, new Comparator<CupRamen>() {
            @Override
            public int compare(CupRamen o1, CupRamen o2) {
                return o1.deadline - o2.deadline;
            }
        });

        PriorityQueue<CupRamen> pq = new PriorityQueue<>();

        int answer = 0;

        // 최대합? 최대를 많게, 최소를 적게 - pq를 minheap 으로
        for (int i = 0; i < list.size(); i++) {
            CupRamen next = list.get(i);
            answer += next.number;
            pq.add(next);
            if (pq.size() > next.deadline) {
                CupRamen value = pq.poll(); // 최솟값 제거하기
                answer -= value.number;
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static class CupRamen implements Comparable<CupRamen> {
        int deadline;
        int number;

        public CupRamen(int deadline, int number) {
            this.deadline = deadline;
            this.number = number;
        }

        @Override
        public int compareTo(CupRamen o) {
            return this.number - o.number;
        }
    }
}