package 프로그래머스.디스크컨트롤러;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution { // 시간 초과
    public static void main(String[] args) {
//        System.out.println(solution(new int[][]{
//                {0, 3},
//                {1, 9},
//                {3, 5}
//        }));

        System.out.println(solution(new int[][]{ // 15가 나와야
                {0, 10},
                {4, 10},
                {5, 11},
                {15, 2}
        }));

        System.out.println(solution(new int[][]{ // 15가 나와야
                {0, 1},
                {0, 2},
                {1, 6},
        }));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        // 우선 시작 시간 순서대로 정렬을 하고
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        // 소요시간 -> 요청 시각 -> 작업의 번호
        PriorityQueue<Disk> pq = new PriorityQueue<>(new Comparator<Disk>() {
            @Override
            public int compare(Disk o1, Disk o2) {
                if (o1.burstTime != o2.burstTime) {
                    return o1.burstTime - o2.burstTime;
                }

                if (o1.startTime != o2.startTime) {
                    return o1.startTime - o2.startTime;
                }

                return o1.number - o2.number;
            }
        });

        int curTime = 0;
        int turnaroundTimeSum = 0;
        int idx = 0;

        while (idx < jobs.length || !pq.isEmpty()) {
            // 현재 시간을 기준으로 시작할 수 있는 작업들을 차례대로 넣어준다.
            while (idx < jobs.length && curTime >= jobs[idx][0]) { // 현재 시간보다 시작시간이 더 작거나 같은 경우에 준비 큐에 넣어 주어야 한다.
                pq.add(new Disk(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (pq.isEmpty()) { // 처리가능한 작업이 없는경우
                curTime = jobs[idx][0]; // 다음 작업 시간으로 이동
            } else { // 처리 가능한 작업이 있는 경우
                Disk curDisk = pq.poll();
                curTime += curDisk.burstTime;
                turnaroundTimeSum += curTime - curDisk.startTime;
            }
        }

        answer = turnaroundTimeSum / jobs.length;

        return answer;
    }

    public static class Disk {
        int number;
        int startTime;
        int burstTime;

        public Disk(int number, int startTime, int burstTime) {
            this.number = number;
            this.startTime = startTime;
            this.burstTime = burstTime;
        }
    }
}
