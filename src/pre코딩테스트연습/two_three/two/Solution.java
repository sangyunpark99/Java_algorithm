package pre코딩테스트연습.two_three.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        new Solution().solution(new int[]{1,3,4,8});
    }

    public int[] solution(int[] nums) {

        ArrayList<Integer> list = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 1; i <= nums.length; i++) { //
            map.put(i,0);
        }

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() == 0){
                list.add(entry.getKey());
            }
        }

        System.out.println(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
