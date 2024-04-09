package 백준.팰린드롬인지확인하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String value = br.readLine();

        StringBuilder reverseValue = new StringBuilder();

        for (int i = value.length() - 1; i >= 0; i--) {
            reverseValue.append(value.charAt(i));
        }

        if (value.equals(reverseValue.toString())) {
            System.out.println(1);
            return;
        }

        System.out.println(0);
    }
}
