package pre코딩테스트연습.two_two.two;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        new Solution().solution(new int[]{0,1,3,5,0,0});
    }

    public int[] solution(int[] arr) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            if(arr[i]%2 == 1){ // 홀 수인경우 한번 더 추가
                list.add(arr[i]);
            }
        }

        if(list.size() > arr.length){
            for (int i = list.size()-1; i > arr.length-1; i--) { // 밀린 수 제거
                list.remove(i);
            }
        }


        System.out.println(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
