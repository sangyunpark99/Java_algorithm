package 큰돌의터전알고리즘강의.five주차.보석도둑복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Jewely> jewelies = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            jewelies.add(new Jewely(weight, price));
        }

        List<Integer> backWeights = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int weight = Integer.parseInt(br.readLine());
            backWeights.add(weight);
        }

        jewelies.sort(new Comparator<Jewely>() {
            @Override
            public int compare(Jewely o1, Jewely o2) {

                return o1.weight - o2.weight;
            }
        });

        Collections.sort(backWeights);

        long answer = 0;

        PriorityQueue<Jewely> pq = new PriorityQueue<>(new Comparator<Jewely>() {
            @Override
            public int compare(Jewely o1, Jewely o2) {
                return o2.price - o1.price;
            }
        });

        int j = 0;
        for (int i = 0; i < k; i++) {
            for (int l = j; l < n; l++) {
                if(backWeights.get(i) >= jewelies.get(l).weight){
                    pq.add(jewelies.get(l));
                    j++;
                }else{
                    break;
                }
            }

            if(!pq.isEmpty()){
                answer += pq.poll().price;
            }
        }

        System.out.println(answer);
    }

    public static class Jewely{
        int weight;
        int price;

        public Jewely(int weight, int price){
            this.weight = weight;
            this.price = price;
        }
    }
}
