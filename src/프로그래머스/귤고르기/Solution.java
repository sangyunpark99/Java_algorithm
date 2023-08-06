package 프로그래머스.귤고르기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
    }

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        // 최대한 중복이 많이 되는 수 챙기기
        // 최소한 중복이 없는 수 챙기기

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }

        // 크기 정렬
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<Integer, Integer> entry : entryList){
            if(k<=0) break;
            answer++;
            k -= entry.getValue();
        }

        return answer;
    }
}
