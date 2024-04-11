package 백준.나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;

    public static String[] values;
    public static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        values = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String value = br.readLine();
            map.put(value, i);
            values[i] = value;
        }

        for (int i = 0; i < M; i++) {
            String value = br.readLine();
            // 숫자, 문자 어떻게 구분?
            char first = value.charAt(0);
            if (Character.isDigit(first)) { // 숫자인 경우
                System.out.println(values[Integer.parseInt(value)]);
            } else { // 문자인 경우
                System.out.println(map.get(value));
            }
        }

    }
}
