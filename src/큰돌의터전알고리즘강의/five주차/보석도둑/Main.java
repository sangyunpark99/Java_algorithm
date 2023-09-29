package 큰돌의터전알고리즘강의.five주차.보석도둑;

import java.io.*;
import java.util.*;
 // 3프로 시간 초과
public class Main {

    public static class Jewelry{
        int weight;
        int price;

        public Jewelry(int weight, int price){
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(weight,price);
        }

        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {

                if(o1.weight == o2.weight){
                    return o2.price - o1.price;
                }

                return o1.weight - o2.weight;
            }
        });

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags); // 오름 차순 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < K; i++) { // 가방을 하나씩 확인하면서

            while(j < N && jewelries[j].weight <= bags[i]){ // j는 처음부터 x
                pq.offer(jewelries[j++].price);
            }

            if(!pq.isEmpty()){ // pq가 비어있지 않은 경우
                ans += pq.poll(); // 제일 무게가 무거운 친구
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}