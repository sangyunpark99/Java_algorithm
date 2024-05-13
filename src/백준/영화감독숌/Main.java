package 백준.영화감독숌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int i = 665;
        while (true) {

            i++;

            if (String.valueOf(i).contains("666")) {
                n--;
            }

            if (n == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
