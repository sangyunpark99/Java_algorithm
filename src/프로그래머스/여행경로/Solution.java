package 프로그래머스.여행경로;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution { // 1차 50% 정답, 문제점 : PriorityQueue는 모든 티켓을 안 돌 확률이 있다.

    private static List<List<String>> answers = new ArrayList<>();
    private static HashMap<String, List<String>> map = new HashMap<>();
    private static HashMap<String, Integer> visited = new HashMap<>();
    private static String[][] tickets;

    public static void main(String[] args) {
//        solution(new String[][]{
//                {"ICN", "JFK"},
//                {"JFK", "ICN"},
//                {"ICN", "ABC"}
//        });
//
//        solution(new String[][]{
//                {"ICN", "JFK"},
//                {"HND", "IAD"},
//                {"JFK", "HND"}
//        });

//        solution(new String[][]{
//                {"ICN", "SFO"},
//                {"ICN", "ATL"},
//                {"SFO", "ATL"},
//                {"ATL", "ICN"},
//                {"ATL", "SFO"}
//        });

//        solution(new String[][]{
//                {"ICN", "AAA"},
//                {"DDD", "ICN"},
//                {"ICN", "DDD"},
//        });

        solution(new String[][]{
                {"EZE", "TIA"},
                {"EZE", "HBA"},
                {"AXA", "TIA"},
                {"ICN", "AXA"},
                {"ANU", "ICN"},
                {"ADL", "ANU"},
                {"TIA", "AUA"},
                {"ANU", "AUA"},
                {"ADL", "EZE"},
                {"ADL", "EZE"},
                {"EZE", "ADL"},
                {"AXA", "EZE"},
                {"AUA", "AXA"},
                {"ICN", "AXA"},
                {"AXA", "AUA"},
                {"AUA", "ADL"},
                {"ANU", "EZE"},
                {"TIA", "ADL"},
                {"EZE", "ANU"},
                {"AUA", "ANU"}
        });
    }

    public static String[] solution(String[][] value) {

        String[] answer = new String[]{};

        tickets = value;

        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];

            if (visited.get(start + end) == null) {
                visited.putIfAbsent(start + end, 1);
            } else {
                visited.put(start + end, visited.get(start + end) + 1);
            }

            map.putIfAbsent(start, new ArrayList<>());
            map.get(start).add(end);
        }

        List<String> list = new ArrayList<>();
        list.add("ICN");
        dfs("ICN", list);

        if (answers.size() == 0) {
            return answer;
        }

        String bfText = String.join("", answers.get(0));
        int answerIdx = 0;

        for (int i = 1; i < answers.size(); i++) {
            String nextValue = String.join("", answers.get(i));

            if (nextValue.compareTo(bfText) < 0) {
                answerIdx = i;
                bfText = nextValue;
            }
        }

        return answers.get(answerIdx).toArray(new String[answers.get(answerIdx).size()]);
    }

    private static void dfs(String curTicket, List<String> path) {

        if (path.size() >= tickets.length && check()) { // 모든 경로를 탐색한 경우
            answers.add(new ArrayList<>(path)); // 리스트 관련 다룰땐 깊은 복사로
            // 기존 배열이랑 비교
            return;
        }

        if (map.get(curTicket) == null) {
            return;
        }

        for (String value : map.get(curTicket)) {
            if (visited.get(curTicket + value) == 0) { // 이마 다 사용함
                continue;
            }
            visited.put(curTicket + value, visited.get(curTicket + value) - 1);
            path.add(value); // 중복될 수 있다.
            int idx = path.size() - 1;
            dfs(value, path);
            path.remove(idx); // 제거해줄 때 추가해 준 것을 제거해 줘야한다.
            visited.put(curTicket + value, visited.get(curTicket + value) + 1);
        }
    }

    private static boolean check() { // 티켓을 전부 사용했는가?
        for (String key : visited.keySet()) {
            if (visited.get(key) > 0) { // 아직 티켓을 다 사용하지 않음
                return false;
            }
        }
        return true;
    }
}