package pre코딩테스트연습.two_two.four;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1,2,1}));
    }

        public int solution(int[] arr) {
            int answer = 0;

            HashMap<Integer,Integer> map = new HashMap<>();

            for (int i = 0; i < arr.length;i++) {
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }

            for (Map.Entry<Integer,Integer> et : map.entrySet()) {
                if(et.getValue() == 1){
                    answer = et.getKey();
                    break;
                }
            }

            return answer;
        }
}
