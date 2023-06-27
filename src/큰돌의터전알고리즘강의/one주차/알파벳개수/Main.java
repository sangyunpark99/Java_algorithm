package 큰돌의터전알고리즘강의.one주차.알파벳개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    // HashMap 사용해서 풀기
    // counting start : 맵 또는 배여얼~
    // String기반 : 맵
    // Integer : array
    // 대문자 A : 65
    // 소문자 a : 97
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Character[] alphabet = new Character[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
        'q','r','s','t','u','v','w','x','y','z'};

        HashMap<Character, Integer> map = new HashMap<>();

        String s = br.readLine();

        for (int i = 0; i < alphabet.length; i++) { // Map 초기화
            map.put(alphabet[i],0);
        }

        for (int i = 0; i < s.length(); i++) { // 초기화된 값
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }

        for (Integer value : map.values()) {
            System.out.print(value + " ");
        }
    }
}
