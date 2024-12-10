package 프로그래머스.명예의전당;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> lowPq = new PriorityQueue<>();

        int idx = 0;

        for (int i = 0; i < k; i++) { // 0, 1, 2
            pq.add(score[i]);
            lowPq.add(score[i]);
            answer[idx++] = lowPq.peek();
        }

        pq.poll();

        for (int i = k; i < score.length; i++) {
            pq.add(score[i]);
            
            answer[idx++] = pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
    }
}
