package 백준.절댓값힙구현하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            nums[i] = value;
        }

        //pq 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int first = Math.abs(o1);
            int second = Math.abs(o2);

            if (first == second) {
                return o1 > o2 ? 1 : -1; // 절댓값이 같은 경우 음수 우선 정렬
            } else {
                return first - second; // 절댓값 기준 정렬
            }
        });

        for (int num : nums) {
            if (num == 0) {
                if (pq.isEmpty()) {
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.add(num);
            }
        }
    }
}
