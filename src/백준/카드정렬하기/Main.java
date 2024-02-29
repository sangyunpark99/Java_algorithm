package 백준.카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) { // 최솟값
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (pq.size() != 1) {
            int data1 = pq.remove();
            int data2 = pq.remove();
            sum += data1 + data2;
            pq.add(data1 + data2);
        }

        System.out.println(sum);
        br.close();
    }
}