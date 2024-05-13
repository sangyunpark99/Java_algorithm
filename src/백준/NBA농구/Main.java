package 백준.NBA농구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구현
// 문자열
public class Main {

    public static int N;

    // 단위 환산도 생각해주어야 함 >> 더했을때 60초가 넘은 경우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int aSum = 0;
        int bSum = 0;
        int A = 0;
        int B = 0;

        String prev = "00:00";
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            String time = st.nextToken();

            if (A > B) {
                aSum += go(time, prev);
            } else if (B > A) {
                bSum += go(time, prev);
            }

            if (team == 1) {
                A++;
            } else {
                B++;
            }

            prev = time; // prev 갱신
        }

        if (A > B) {
            aSum += go("48:00", prev);
        } else if (B > A) {
            bSum += go("48:00", prev);
        }

        print(aSum);
        print(bSum);
    }

    public static void print(int sum) {
        int minute = sum / 60;
        int second = sum % 60;

        System.out.printf("%02d:%02d\n", minute, second);
    }

    public static int go(String time, String prev) {
        return changeMinuteToSecond(time) - changeMinuteToSecond(prev);
    }

    public static int changeMinuteToSecond(String time) { // 단위를 하나로 해준다.
        int minute = Integer.parseInt(time.substring(0, 2));
        int second = Integer.parseInt(time.substring(3, 5));

        return minute * 60 + second;
    }
}
