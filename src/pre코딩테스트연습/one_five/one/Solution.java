package pre코딩테스트연습.one_five.one;

import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution("google"));
    }

    public static String solution(String s) {
        String answer = "";

        TreeMap<String,Integer> map = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(String.valueOf(s.charAt(i)),map.getOrDefault(String.valueOf(s.charAt(i)),0)+1);
        }

        int maxNum = 0;

        for (Integer value : map.values()) {
            if(maxNum < value){
                maxNum = value;
            }
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if(stringIntegerEntry.getValue() == maxNum){
                answer = stringIntegerEntry.getKey();
                break;
            }
        }

        return answer;
    }
}
