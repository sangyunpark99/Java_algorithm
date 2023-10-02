package 큰돌의터전알고리즘강의.five주차.칠무해;

import java.io.*;
import java.util.Objects;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Float> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {

            float score = Float.parseFloat(br.readLine());
            pq.offer(score);
        }

        for (int i = 0; i < 7; i++) {
            bw.write(Objects.requireNonNull(pq.poll()).toString()+"00"+ '\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
