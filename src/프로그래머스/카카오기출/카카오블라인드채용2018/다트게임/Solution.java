package 프로그래머스.카카오기출.카카오블라인드채용2018.다트게임;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("1S*2T*3S"));
    }

    public int solution(String dartResult) {
        int answer = 0;

        // S,D,T -> 1,2,3 제곱근
        // *,# -> * : 해당 점수와 바로 전에 얻은 점수 2배, # : 해당 점수 마이너스

        Map<Character, Integer> map = new HashMap<>();
        map.put('S', 1);
        map.put('D', 2);
        map.put('T', 3);

        List<Integer> numbers = new ArrayList<>();
        String number = "";
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if (Character.isDigit(ch)) { // 숫자를 만난 경우
                number += ch;
            } else if (ch == 'S' || ch == 'D' || ch == 'T') { // 보너스
                int num = Integer.parseInt(number);
                numbers.add((int) Math.pow(num, map.get(ch)));
                number = "";
            } else { // 옵션
                if (ch == '*') {

                    if (numbers.size() == 1) {
                        numbers.set(numbers.size() - 1, numbers.get(numbers.size() - 1) * 2);
                    } else {
                        numbers.set(numbers.size() - 1, numbers.get(numbers.size() - 1) * 2);
                        numbers.set(numbers.size() - 2, numbers.get(numbers.size() - 2) * 2);
                    }

                } else if (ch == '#') {
                    numbers.set(numbers.size() - 1, numbers.get(numbers.size() - 1) * -1);
                }
            }
        }

        for (int i = 0; i < numbers.size(); i++) {
            answer += numbers.get(i);
        }

        return answer;
    }
}
