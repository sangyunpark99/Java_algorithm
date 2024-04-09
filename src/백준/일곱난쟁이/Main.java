package 백준.일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = new int[9];

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }

        Arrays.sort(a);

        // 2개만 선택하면 된다? 2포인터 쓰자
        // 이중 포문도 가능

        int firstIdx = 0;
        int secondIdx = 0;

        for (int i = 0; i < 8; i++) {
            int flag = 0;
            for (int j = 0; j < 9; j++) {
                if (sum - (a[i] + a[j]) == 100) {
                    firstIdx = i;
                    secondIdx = j;
                    flag = 1;
                    break; // break말고 바로 return해주어도 된다.
                }
            }
            if (flag == 1) {
                break;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == firstIdx || i == secondIdx) {
                continue;
            }
            System.out.println(a[i]);
        }
    }
}
