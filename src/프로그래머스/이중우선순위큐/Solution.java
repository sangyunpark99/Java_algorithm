package 프로그래머스.이중우선순위큐;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<Integer> solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        // 초기화
        for (String value : operations) {
            if (value.contains("I")) {
                int number = Integer.parseInt(value.split(" ")[1]);
                min.add(number);
                max.add(number);
            } else {

                if (min.size() == 0) { // 큐가 비어있는 경우 넘어가
                    continue;
                }

                if (value.contains("D 1")) {
                    min.remove(max.poll());
                } else { // 삭제할 때 수가 중복되는 경우 하나만 제거한다.
                    max.remove(min.poll());
                }
            }
        }

        List<Integer> list = new ArrayList<>(min);

        if (list.size() == 0) { // 0개일 때
            list.add(0);
            list.add(0);
            return list;
        }

        if (list.size() == 1) { // 1개일 때
            return list;
        }

        if (list.size() >= 2) { // 2개 이상일 때
            list = new ArrayList<>();
            list.add(max.poll());
            list.add(min.poll());
        }

        return list;
    }
}
