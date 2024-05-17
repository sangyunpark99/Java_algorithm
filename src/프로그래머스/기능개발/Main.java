package 프로그래머스.기능개발;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Integer> solution(int[] progresses, int[] speeds) {

        List<Integer> progress = init(progresses);
        List<Integer> speed = init(speeds);

        List<Integer> answer = new ArrayList<>();

        while (progress.size() != 0) {

            int cnt = 0;

            for (int i = 0; i < progress.size(); i++) { // 다 더해주고
                int sv = speed.get(i);
                progress.set(i, progress.get(i) + sv);
            }

            for (int i = 0; i < progress.size(); i++) {
                if (progress.get(i) >= 100 && i == 0) { // 앞에 아무것도 없을때
                    progress.remove(i);
                    speed.remove(i);
                    i--;
                    cnt++;
                }
            }

            if (cnt > 0) {
                answer.add(cnt);
            }
        }

        return answer;
    }

    public List<Integer> init(int[] array) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }

        return list;
    }
}
