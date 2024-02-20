package 백준.수들의합5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 1; // 자기 자신인 경우
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while (end_index != N) {
            if (sum == N) {
                cnt++;
                end_index++;
                sum += end_index;
            } else if (sum < N) {
                end_index++;
                sum += end_index;
            } else {
                sum -= start_index; // 이전 start_index 빼고
                start_index++; // ++
            }
        }

        System.out.println(cnt);
    }
}
