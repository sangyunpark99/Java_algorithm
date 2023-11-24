package 프로그래머스.기본문제.완주하지못한선수;

import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= (entry.getValue() + 1); // 착용하지 않는 경우의 수 생각해주기
        }

        return answer - 1; // 모두 착용 안하는 경우의 수 빼주기
    }
}