package 이주만에통과하는알고리즘.완전탐색.백준2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<List<String>> input = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            String number = stk.nextToken();
            String strike = stk.nextToken();
            String ball = stk.nextToken();
            input.add(List.of(number, strike, ball));
        }

        int res = 0;

        for (int j = 1; j <= 9; j++) {
            for (int k = 1; k <= 9; k++) {
                for (int l = 1; l <= 9; l++) {
                    if (j == k || k == l || j == l) {
                        continue;
                    }
                    String number = "" + j + k + l;
                    if (check(input, number) == input.size()) {
                        res++;
                    }
                }
            }
        }

        System.out.println(res);
    }

    private static int check(List<List<String>> input, String number) {

        int count = 0;

        for (int i = 0; i < input.size(); i++) {
            if ((checkStrike(input.get(i), number) == Integer.parseInt(input.get(i).get(1))) &&
                    (checkBall(input.get(i), number) == Integer.parseInt(input.get(i).get(2)))) { // ball 갯수
                count++;
            }
        }

        return count;
    }

    private static int checkStrike(List<String> input, String number) {

        int count = 0;
        String inputNumber = input.get(0);
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) == number.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    private static int checkBall(List<String> input, String number) {
        int count = 0;
        String inputNumber = input.get(0);
        for (int i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) != number.charAt(i) && number.contains(String.valueOf(inputNumber.charAt(i)))) {
                count++;
            }
        }

        return count;
    }
}
