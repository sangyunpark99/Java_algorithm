package 큰돌의터전알고리즘강의.five주차.보석도둑;

import java.io.*;
import java.util.*;
 // 3프로 시간 초과
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] jwely = new int[n][2];

        for (int i = 0; i < n; i++) { // 보석 크기, 가격 받아오기
            stk = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(stk.nextToken());
            int price = Integer.parseInt(stk.nextToken());

            jwely[i][0] = weight;
            jwely[i][1] = price;
        }

        int[] backWeights = new int[k]; // 가방 무게

        for (int i = 0; i < k; i++) { // 가방 무게 받아오기
            int maxWeight = Integer.parseInt(br.readLine());
            backWeights[i] = maxWeight; // 가방 무게
        }

        // 1. 보석의 가격을 기준으로 정렬, 단 가격이 같은 경우 크기를 기준으로 정렬

        Arrays.sort(jwely, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(Objects.equals(o1[1], o2[1])){ // 가격이 같은 경우
                    return o1[0] - o2[1];
                }
                return o2[1] - o1[1]; // 가격은 내림차순 정렬
            }
        });

        int answer = 0; // 보석의 총 가격

        // 가방에 담기
        // 보석 무게와 제일 근접한 가방에 담기 가방 무게와 보석무게의 차이가 가장 작은 가방에 담기

        int getJwely = 0;
        for (int i = 0; i < jwely.length; i++) { // 보석을 하나씩 돌면서

            if(getJwely == k){ // 가방 갯수 만큼 보석을 뽑은 경우 - 반복문 종
                System.out.println(answer);
                return;
            }

            int jwelyWeight = jwely[i][0]; // 보석 무게
            int jwelyPrice = jwely[i][1];

            // 차이가 작은 가방에 넣어주기
            ArrayList<Integer> weightGap = new ArrayList<>(); // 보석과 가방의 무게 차이
            for (int j = 0; j < backWeights.length; j++) {
                if(jwelyWeight <= backWeights[j]){ // 보석보다 가방무게가 크거나 같은 경우
                    weightGap.add(backWeights[j] - jwelyWeight); // 가방과 보석의 차이를 넣어줌
                }
            }

            // 차이가 가장 작은 가방이 담을 수 있는 무게를 0으로 만들어 못담게 하기
            // 보석을 담은 걸 체크
            if(!weightGap.isEmpty()){ // 비어있지 않은 경우 -> 충분히 담을 수 있는 경우
                int minIdx = -1;
                int minValue = Integer.MAX_VALUE;
                for (int j = 0; j < weightGap.size(); j++) { // 갭을 돌면서 제일 작은 사이즈 찾기
                    int gap = weightGap.get(j);
                    if(minValue > gap){
                        minValue = gap;
                        minIdx = j;
                    }
                }

                backWeights[minIdx] = 0;
                getJwely++; // 보석 뽑음
                answer += jwelyPrice;// 뽑은 보석의 가격을 더해주어야 함
            }

        }

        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
}