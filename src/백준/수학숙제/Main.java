package 백준.수학숙제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static ArrayList<BigInteger> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            String[] a = s.split("[^0-9]"); // 숫자가 아닌 것들로 분리

            for (int j = 0; j < a.length; j++) {
                if (!a[j].equals("")) {
                    res.add(new BigInteger(a[j]));
                }
            }
        }

        Collections.sort(res);

        StringBuilder sb = new StringBuilder();

        for (BigInteger value : res) {
            sb.append(value + "\n");
        }

        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
    }
}