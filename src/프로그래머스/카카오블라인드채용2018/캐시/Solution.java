package 프로그래머스.카카오블라인드채용2018.캐시;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        List<String> cache = new ArrayList<>();

        if (cacheSize == 0) {
            answer += cities.length * 5;
            return answer;
        }

        for (String value : cities) {
            String name = value.toUpperCase();

            if (cache.contains(name)) {
                answer++;
                cache.remove(name);
                cache.add(name);
            } else {
                answer += 5;
                if (cache.size() < cacheSize) {
                    cache.add(name);
                } else {
                    cache.remove(0);
                    cache.add(name);
                }
            }
        }

        return answer;
    }
}