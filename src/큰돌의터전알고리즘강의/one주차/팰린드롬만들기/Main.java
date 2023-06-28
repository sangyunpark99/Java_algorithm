package 큰돌의터전알고리즘강의.one주차.팰린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    // 알파벳 오름차순이므로 TreeMap을 사용해주어야 한다.
    // 아님 배열로 하면 된다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        // 입력 순서 지키기
        TreeMap<Character, Integer> map = new TreeMap<>(); // 오름차순 지키기

        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        int count = 0; // 홀수개 2개 이상 존재하는 경우 불가능
        for (Character character : map.keySet()) {
            if(map.get(character) % 2 == 1){ // 홀수의 갯수가 존재하는 경우
                count++;
            }
        }

        if(count >= 2){ // 홀수 2개 이상 존재하는 경우 Sorry 후 return
            System.out.println("I'm Sorry Hansoo\n");
            return;
        }

        Character chMiddle = 'a';

        for (Character character : map.keySet()) {

            if(map.get(character) % 2 == 1){ // 중앙값 찾기
                chMiddle = character;
                map.put(character, map.get(character) - 1);
            }
        }

        for (Map.Entry<Character, Integer> Entry : map.entrySet()) {

            for (int i = 0; i < Entry.getValue()/2; i++) {
                answer += Entry.getKey();
            }
        }

        StringBuffer stb = new StringBuffer(answer);

        if(chMiddle == 'a'){ // 중앙값이 존재하지 않는다면
            answer += stb.reverse();
        }else{
            answer += chMiddle;
            answer += stb.reverse();
        }

        System.out.println(answer);
    }
}
