package 백준.농구경기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static int[] names;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        names = new int[26];

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            char firstName = name.charAt(0);
            names[firstName - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < names.length; i++) {
            if (names[i] >= 5) {
                char value = (char) (i + 'a');
                sb.append(value);
            }
        }

        if (sb.toString().length() > 0) {
            bw.write(sb.toString());
        } else {
            bw.write("PREDAJA");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
