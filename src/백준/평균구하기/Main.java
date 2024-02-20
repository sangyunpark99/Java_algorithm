package 백준.평균구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String m = br.readLine();

        String[] array = m.split(" ");

        int maxValue = Integer.MIN_VALUE;
        double sum = 0;

        for (String value : array) {
            maxValue = Math.max(maxValue, Integer.parseInt(value));
            sum += Double.parseDouble(value);
        }

        System.out.println(sum * 100 / maxValue / array.length);
    }
}
