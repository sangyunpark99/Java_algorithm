package 백준.수정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String nums = br.readLine();
        int sum = 0;

        for (int i = 0; i < nums.split("").length; i++) {
            sum += Integer.parseInt(nums.split("")[i]);
        }

        System.out.println(sum);

        br.close();
    }
}
