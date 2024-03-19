package 백준.타임머신;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static ArrayList<ArrayList<City>> a;
    public static long[] dist; // 자료형 int로 할시 오버플로우 발생
    public static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new ArrayList<>();
        dist = new long[N + 1]; // 1부터 시작

        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
            dist[i] = INF; // INF로 거리 초기화
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            a.get(A).add(new City(B, C));
        }

        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) { // 음의 사이클이 존재
            sb.append("-1\n");
        } else { // 음의 사이클이 존재 x
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dist[i] + "\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bellmanFord() {
        dist[1] = 0; // 1번 도시에서 출발해서~
        boolean update = false;

        for (int i = 1; i < N; i++) { // N-1번 동안 최단거리 초기화 작업을 반복
            update = false;
            for (int j = 1; j <= N; j++) {
                for (City city : a.get(j)) {
                    if (dist[j] == INF) {
                        break;
                    }

                    if (dist[city.end] > dist[j] + city.weight) {
                        dist[city.end] = dist[j] + city.weight;
                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }

        if (update) {
            for (int i = 1; i <= N; i++) {
                for (City city : a.get(i)) {
                    if (dist[i] == INF) {
                        break;
                    }

                    if (dist[city.end] > dist[i] + city.weight) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static class City {
        int end;
        int weight;

        public City(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}