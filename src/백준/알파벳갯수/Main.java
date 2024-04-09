package 백준.알파벳갯수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] alphabet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String value = br.readLine();

        alphabet = new int[26];

        for (char a : value.toCharArray()) {
            alphabet[a - 'a']++;
        }

        for (int i = 0; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }
}
