package 프로그래머스.lv3베스트앨범;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 500, 500, 500, 500})));
    }

    public static int[] solution(String[] genres, int[] plays) { // 1차 86.7점, 2차

        HashMap<String, Integer> map = new HashMap<>(); // 총 합계 구하기
        HashMap<String, PriorityQueue<int[]>> songs = new HashMap<>(); // 핵심
        // 우선순위큐를 한가지 기준만 잡지 않고, 여러개 기준을 잡을 수 있다.
        // 배열로 선언한 이유는 기준이 2개가 되므로 {재생횟수, 인덱스} 이렇게 잡게 된다.

        for (int i = 0; i < plays.length; i++) { // O(n) = 10,000
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

            // 아무런 값도 존재하지 않을 경우 PQ를 넣어 주어야 한다.
            songs.putIfAbsent(genres[i], new PriorityQueue<>((a, b) -> { // 키가 존재하지 않은 경우 작업
                if (b[0] == a[0]) { // 재생 횟수 같은 경우
                    return a[1] - b[1]; // 인덱스 오름 차순
                }
                return b[0] - a[0]; // 재생 횟수 내림차순
            })); // 우선순위 큐 생성

            // 배열 -> {재생횟수, 인덱스}
            songs.get(genres[i]).add(new int[]{plays[i], i}); //
        }

        List<String> sortedKeys = new ArrayList<>(map.keySet()); // key를 기준으로
        sortedKeys.sort((o1, o2) -> map.get(o2) - map.get(o1)); // 총 재생 횟수로 내림 차순

        List<Integer> answer = new ArrayList<>();

        for (String genre : sortedKeys) {
            PriorityQueue<int[]> pq = songs.get(genre); // 우선순위 큐 -> 인덱스 기준
            for (int i = 0; i < 2 && !pq.isEmpty(); i++) { // 조건문을 2개로 조정
                answer.add(pq.poll()[1]); // 인덱스 추가
            }
        }

        // intValue -> Integer를 int로 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}