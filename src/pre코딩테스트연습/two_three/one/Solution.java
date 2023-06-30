package pre코딩테스트연습.two_three.one;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("221123"));
    }

    public String solution(String s) {
        String answer = "";

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt(String.valueOf(s.charAt(i)));
            map.put(n,map.getOrDefault(n,0)+1);
        }

        List<Integer> keySetList = new ArrayList<>(map.keySet());
        // value 값으로 내림차순 정렬
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        for (Integer integer : keySetList) {
            answer += integer;
            answer += " ";
        }

        for (int i = 0; i < 10; i++) {
            if(!answer.contains(String.valueOf(i))){
                answer +=i;
                answer += " ";
            }
        }

        return answer.substring(0,answer.length()-1);
    }
}
