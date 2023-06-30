package pre코딩테스트연습.two_three.five;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(7,3));
    }

    public int solution(int N, int K) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;

        while(list.size()!=1){
            index = (index + (K-1)) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }
}
