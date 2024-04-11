package 백준.패션왕신혜빈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static int T;
    public static int N;
    public static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for (int i = 0; i < T; i++) {
            int answer = 1;
            N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) { // 초기화
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();

                map.put(kind, map.getOrDefault(kind, 0) + 1);
            }

            for (Map.Entry<String, Integer> entrySet : map.entrySet()) {
                answer *= (map.get(entrySet.getKey()) + 1); // 안입는 경우
            }

            System.out.println(answer - 1); // 전부다 안입는 경우
            map = new HashMap<>(); // 맴 초기화
        }
    }
}
