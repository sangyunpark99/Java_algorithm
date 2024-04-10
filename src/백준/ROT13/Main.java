package 백준.ROT13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 알파벳 대문자 : 65 ~ 90
// 알파벳 소문자 : 97 ~ 122

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String values = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char value : values.toCharArray()) {
            char ansValue = value;

            if (Character.isLowerCase(value)) { // 소문자 :
                ansValue = (char) ((value + 13) > 122 ? (value + 13) % 122 + 96 : value + 13);
            } else if (Character.isUpperCase(value)) { // 대문자
                ansValue = (char) ((value + 13) > 90 ? (value + 13) % 90 + 64 : value + 13);
            }
            sb.append(ansValue);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
