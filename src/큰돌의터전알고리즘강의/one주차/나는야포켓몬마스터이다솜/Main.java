package 큰돌의터전알고리즘강의.one주차.나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 일부 포켓몬 : 마지막 문자만 대문자
        // 알파벳 -> 포켓몬 번호
        // 숫자 -> 포켓몬 번호에 해당하는 문자를 출력

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) { // 포켓몬 도감에 이름 추가
            String name = br.readLine();
            map1.put(name,i);
            map2.put(i,name);
        }

        // 시간복잡도 때문에 HashMap 2개 사용
        for (int i = 0; i < m; i++) {
            String find = br.readLine();
            char ch = find.charAt(0);
            if(!Character.isDigit(ch)){ // 대소문자 인경우 - 맨 앞글자가 소문자 일때도 생각해줘야함
                // 숫자를 출력
                System.out.println(map1.get(find));
            }else{ // 숫자인 경우
                System.out.println(map2.get(Integer.parseInt(find)));
            }
        }
    }
}
