package 프로그래머스.추억점수;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"may","kein","kain","radi"}, new int[]{5,10,1,3}, new String[][]{{"may","kein","kain","radi"},{"may","kein","brin","deny"},{"kon","kain","may","coni"}})));
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo){
        int[] answer = new int[photo.length];

        Map<String,Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; i++) { // Map 만들기
            map.put(name[i],yearning[i]);
        }

        // 2차원 배열
        for (int i = 0; i < photo.length; i++) {
            int answer_each = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if(map.containsKey(photo[i][j])){ // 존재하는지 확인 null인경우 덧셈 에러남
                    answer_each += map.get(photo[i][j]);
                }
            }
            answer[i] = answer_each;
        }

        return answer;
    }
}
