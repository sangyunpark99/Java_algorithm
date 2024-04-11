package 백준.팰린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] alphabet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String values = br.readLine();

        alphabet = new int[26];
        // 홀수 갯수인 알파벳을 기준으로 삼는다.
        for (char value : values.toCharArray()) {
            alphabet[value - 'A']++;
        }

        int cnt = 0;
        int idx = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] % 2 == 1) {
                cnt++;
                idx = i;
                alphabet[i]--; // 하나 빼주기
            }
        }

        String answer = "";

        if (cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else if (cnt == 0) {
            String value = copy();
            answer = value + reverse(value);
        } else if (cnt == 1) {
            String value = copy();
            answer = value + (char) ('A' + idx) + reverse(value);
        }

        System.out.println(answer);
    }

    private static String copy() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] % 2 == 0) { // 짝수 갯수인 것만
                int totalValue = alphabet[i] / 2;
                for (int j = 0; j < totalValue; j++) {
                    char value = (char) ('A' + i);
                    sb.append(value);
                }
            }
        }

        return sb.toString();
    }

    private static String reverse(String value) {
        StringBuilder sb = new StringBuilder(value);
        return sb.reverse().toString();
    }
}
