package 큰돌의터전알고리즘강의.five주차.칠무해;

import java.io.*;
import java.util.*;

public class Main {
    // java는 우선순위 큐의 우선순위가 값이 작은데에 귀결된다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Float> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {

            float num = Float.parseFloat(br.readLine());

            if(pq.size() == 7){ // 우선순위 교체
                pq.add(num);
                pq.poll(); // 제일 큰거 제거
            }else pq.add(num);

        }

        PriorityQueue<Float> result = new PriorityQueue<>();

        while(!pq.isEmpty()){
            result.add(pq.poll());
        }

        for (int i = 0; i < 7; i++) {
            System.out.printf("%.3f\n",result.poll());
        }

    }
}
