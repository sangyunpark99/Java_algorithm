package 백준.빈도정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int N, C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        List<Integer> order = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        // 각 숫자별 갯수 파악
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            map.put(value, map.getOrDefault(value, 0) + 1); // 빈도수 저장
            order.add(value); // 순서 저장
            answer.add(value);
        }

        // 정렬
        Collections.sort(answer, (o1, o2) -> {
            if (map.get(o1) == map.get(o2)) { // 빈도수가 같은 경우, 원래 입력 값대로
                return order.indexOf(o1) - order.indexOf(o2);
            } else { // 빈도수가 다른 경우, 빈도수 내림차순 정렬
                return map.get(o2) - map.get(o1);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int value : answer) {
            sb.append(value + " ");
        }

        System.out.println(sb);
    }
}