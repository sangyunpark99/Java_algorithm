package 큰돌의터전알고리즘강의.two주차.빈도정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 같은 경우 indexOf로 가장 먼저 나온 값 비교

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];

        int j = 0;
        while(stk.hasMoreTokens()){
            numbers[j] = Integer.parseInt(stk.nextToken());
            j++;
        }

        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        // LinkedHashMap 입력받은 순서 기억

        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], map.getOrDefault(numbers[i],0)+1);
        }

        // entryList로 내림차순 정렬
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());

        // HashMap 정렬 -
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < entryList.size(); i++) {
            for (int k = 0; k < entryList.get(i).getValue(); k++) {
                sb.append(entryList.get(i).getKey());
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
