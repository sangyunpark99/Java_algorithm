package 백준.괄호추가하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Character> oper_str;
    public static ArrayList<Integer> nums;

    public static int N, res;
    public static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        s = br.readLine();

        oper_str = new ArrayList<>();
        nums = new ArrayList<>();
        res = Integer.MIN_VALUE;

        // 숫자와 문자 분리
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) { // 숫자인 경우
                nums.add(Character.getNumericValue(s.charAt(i)));
            } else { // 문자인 경우
                oper_str.add(s.charAt(i));
            }
        }

        go(0, nums.get(0));

        bw.write(res + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void go(int here, int num) {
        if (here == nums.size() - 1) {
            res = Math.max(res, num);
            return;
        }

        // 2가지 경우로 나뉜다.

        // 앞의 값 먼저 계산
        go(here + 1, oper(oper_str.get(here), num, nums.get(here + 1)));

        // 뒤에꺼 괄호해주기(마지막 값) - 오버플로우 체크
        if (here + 2 <= nums.size() - 1) {
            int tmp = oper(oper_str.get(here + 1), nums.get(here + 1), nums.get(here + 2)); // 뒤에 먼저 계산하고
            go(here + 2, oper(oper_str.get(here), num, tmp)); // 앞의 값 같이 계산하기
        }
    }

    public static int oper(char a, int b, int c) {
        if (a == '+') {
            return b + c;
        }
        if (a == '-') {
            return b - c;
        }
        return b * c;
    }
}