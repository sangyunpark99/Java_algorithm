package 프로그래머스.의상;

import java.util.HashMap;

class Main {

    public static int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }

        for (int value : map.values()) {
            answer *= (value + 1);
        }

        answer -= 1;

        return answer;
    }
}