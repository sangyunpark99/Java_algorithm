package 연습문제.practice1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("552342502"));
    }

    public static int solution(String s){
        int answer = 0;

        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i <s.length(); i++) {
            map.put(String.valueOf(s.charAt(i)),map.getOrDefault(String.valueOf(s.charAt(i)),0)+1);
        }

        System.out.println(map);

        int maxNum = 0;
        int maxKey = 0;

        for (String s1 : map.keySet()) { // 최댓값 찾기
            if(map.get(s1) > maxNum){
                maxNum = map.get(s1);
                maxKey = Integer.valueOf(s1);
            }
        }

        // 같은 값 찾기
        ArrayList<Integer> list = new ArrayList<>();
        list.add(maxKey);

        for (String s1 : map.keySet()) {
            if(map.get(s1) == maxNum){
                list.add(Integer.parseInt(s1));
            }
        }

        if(list.size() > 1){
            Collections.sort(list);
            answer = list.get(0);
        }else{
            answer = maxKey;
        }

        return answer;
    }
}
