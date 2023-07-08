package pre코딩테스트연습.three_two.one;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("0",2));
    }

    public int solution(String s, int n) {
        int answer = 0;

        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            String name = String.valueOf(s.charAt(i));
            map.put(name,map.getOrDefault(name,0)+1);
        }

        if(map.containsKey(String.valueOf(n))){
            answer = map.get(String.valueOf(n));
        }

        return answer;
    }
}
