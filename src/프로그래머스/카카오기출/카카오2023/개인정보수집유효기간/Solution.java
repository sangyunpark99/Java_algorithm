package 프로그래머스.카카오기출.카카오2023.개인정보수집유효기간;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 항목이 2개인 경우 HashMap
// 여러개인경우 class
// 정렬기준이 여러개인 경우 class
// 정렬기준이 여러개가 아닌경우 HashMap

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        int todayCount = getDays(today);

        Map<String, String> termMap = new HashMap<>();

        for (String term : terms) {
            String[] value = term.split(" ");
            String alphabet = value[0];
            String month = value[1];

            termMap.put(alphabet, month);
        }

        List<Integer> destroyList = new ArrayList<>();

        int idx = 1;
        for (String privacy : privacies) {
            String[] value = privacy.split(" ");
            String date = value[0];
            String alphabet = value[1];

            int addMonth = Integer.parseInt(termMap.get(alphabet));

            int limitDay = getDays(date) + getDays(addMonth);
            if (todayCount >= limitDay) {
                destroyList.add(idx);
            }
            idx++;
        }

        answer = new int[destroyList.size()];

        for (int i = 0; i < destroyList.size(); i++) {
            answer[i] = destroyList.get(i);
        }

        return answer;
    }

    public int getDays(String day) {
        String[] todayWords = day.split("\\.");
        int y = Integer.parseInt(todayWords[0]);
        int m = Integer.parseInt(todayWords[1]);
        int d = Integer.parseInt(todayWords[2]);

        return y * 28 * 12 + m * 28 + d;
    }

    public int getDays(int m) {
        return m * 28;
    }
}
