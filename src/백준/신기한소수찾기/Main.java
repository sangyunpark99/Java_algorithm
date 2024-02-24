package 백준.신기한소수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] nums = {2, 3, 5, 7}; // 소수인 것만

        for (int num : nums) {
            dfs(num, 1);
        }
    }

    public static void dfs(int num, int jarisu) {
        if (jarisu == N) {
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }

        for (int i = 1; i < 10; i++) { // 2로 끝나는건 무조건 짝수, 뒤에 붙을 수를 생각
            if (i % 2 == 0) {
                continue;
            }

            if (isPrime(10 * num + i)) { // 소수인 경우, 연속해서 붙을 수를 생각해준다.
                dfs(10 * num + i, jarisu + 1); // 자릿수 추가해서 또다른 소수 찾
            }
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
