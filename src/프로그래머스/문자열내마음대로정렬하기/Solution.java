package 프로그래머스.문자열내마음대로정렬하기;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"abce","abcd","cdx"},1)));
    }

    public static String[] solution(String[] strings, int n) {

        Arrays.sort(strings);

        String[] answer = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            String sub = strings[i].substring(n,n+1);
            answer[i] = sub;
        }

        Arrays.sort(answer); // 추출한 값으로 정렬하기

        ArrayList<String> list = new ArrayList<>(Arrays.asList(strings)); // Array -> ArrayList로 형변환

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if(answer[i].equals(list.get(j).substring(n,n+1))){ // 값비교는 equals
                    answer[i] = list.get(j);
                    list.remove(j);
                    break; // 찾았다!, 다른 경우로 갈 필요 x
                }
            }
        }

        return answer;
    }
}
