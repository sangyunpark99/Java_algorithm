package 백준.비밀번호발음하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<Character> vowel = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String value = br.readLine();
            if ("end".equals(value)) {
                break;
            }

            check(value);
        }
    }

    public static void check(String value) {

        boolean check = true;

        // 1. 모음은 반드시 한개 포함
        for (int i = 0; i < value.length(); i++) {
            char a = value.charAt(i);
            if (vowel.contains(a)) { // 하나라도 포함된 경우
                break;
            }

            if (i == value.length() - 1) { // 마지막까지 못 찾은 경우
                check = false; // 무조건 false로 해주면 안된다.
            }
        }

        // 2. 모음이 3개 혹은 자음이 3개 연속 오면 안된다.
        int cnt = 0;
        int n = 0; // 0 : 모음, 1 : 자음

        for (char a : value.toCharArray()) {

            int cn;

            if (vowel.contains(a)) { // 모음인 경우
                cn = 0;
            } else { // 자음인 경우
                cn = 1;
            }

            if (n != cn) { // 이전값과 다르고
                cnt = 1;
                n = cn;
            } else {
                cnt++;
            }

            if (cnt == 3) {
                check = false;
                break;
            }
        }

        char before = ' ';
        cnt = 0;

        // 3. 같은 글자 연속으로 두번 오면 x, ee와 oo는 허용
        for (char a : value.toCharArray()) {
            if (before != a) { // 같은 글자가 아닌 경우
                cnt = 1;
                before = a;
            } else { // 같은 글자인 경우
                cnt++;
            }

            if (cnt == 2) {
                if (before != 'e' && before != 'o') { // e나 o가 둘 다 아닌 경우
                    check = false;
                    break;
                }
            }
        }

        if (check) {
            System.out.printf("<%s> is acceptable.\n", value);
        } else {
            System.out.printf("<%s> is not acceptable.\n", value);
        }
    }
}