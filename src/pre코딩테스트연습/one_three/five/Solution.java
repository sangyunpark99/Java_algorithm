package pre코딩테스트연습.one_three.five;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"혁준","히밥","양상","심심이","소스왕"},new String[]{"혁준","양상"},new String[]{"심심이","소스왕"}));
    }

    public static String solution(String[] bj, String[] one, String[] two) {
        HashMap<String,Integer> map = new HashMap<>();

        for (int i = 0; i < bj.length; i++) {
            map.put(bj[i],0);
        }

        for (int i = 0; i < one.length; i++) {
            if(map.containsKey(one[i])){
                map.replace(one[i],1);
            }
        }

        for (int i = 0; i < two.length; i++) {
            if(map.containsKey(two[i])){
                map.replace(two[i],2);
            }
        }

        int totalNum = 0;
        String winner = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 0){
                totalNum += 3 * 150;
                winner = entry.getKey();
            }else{
                totalNum += entry.getValue() * 150;
            }
        }

        String answer = totalNum + "만원" + "(" + winner + ")";

        return answer;
    }
}
