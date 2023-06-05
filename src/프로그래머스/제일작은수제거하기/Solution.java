package 프로그래머스.제일작은수제거하기;

import java.util.ArrayList;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{4,3,2,1}));
    }

    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        if(arr.length == 1){ // 크기 1인 경우
            answer.add(-1);
            return answer;
        }

        for(int item : arr) { // 값 추가
            answer.add(item);
        }

        int min = 999999;

        for(int item: answer){
            if(min > item){
                min = item;
            }
        }
        answer.remove(Integer.valueOf(min));

        return answer;
    }
}
