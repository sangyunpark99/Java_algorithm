package 프로그래머스.카카오기출.카카오블라인드채용2018.셔틀버스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        List<Integer> crews = new ArrayList<>();

        for (int i = 0; i < timetable.length; i++) { // 시간 -> 분단위로 환산
            int time = Integer.parseInt(timetable[i].substring(0, 2)) * 60 + Integer.parseInt(
                    timetable[i].substring(3, 5));
            crews.add(time);
        }

        Collections.sort(crews);

        int busStart = 540;
        int nextIdx = 0;
        int cornTime = 0;
        for (int i = 0; i < n; i++) {
            int ride = 0;
            for (int j = nextIdx; j < crews.size(); j++) {
                if (busStart >= crews.get(j)) {
                    ride++;
                    nextIdx++;
                    if (ride == m) {
                        break;
                    }
                } else {
                    break;
                }
            }

            if (i == n - 1) {
                if (ride == m) {
                    cornTime = crews.get(nextIdx - 1) - 1;
                } else {
                    cornTime = busStart;
                }
            }

            busStart += t;
        }

        String time = cornTime / 60 < 10 ? String.format("%02d", cornTime / 60) : String.format("%02d", cornTime / 60);
        String minute =
                cornTime / 60 < 10 ? String.format("%02d", cornTime % 60) : String.format("%02d", cornTime % 60);

        answer = time + ":" + minute;

        return answer;
    }
}
