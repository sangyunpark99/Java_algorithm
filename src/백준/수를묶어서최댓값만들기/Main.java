package 백준.수를묶어서최댓값만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());

        int one = 0;

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value <= 0) { // 0을 넣어주는 이유는 음수를 상쇄시키기 위해서
                minus.add(value);
            } else if (value == 1) {
                one++;
            } else {
                plus.add(value);
            }
        }

        int sum = 0;
        while (minus.size() >= 2) { // 음수는 작을수록
            int data1 = minus.remove();
            int data2 = minus.remove();
            sum += (data1 * data2);
        }

        while (plus.size() >= 2) {
            int data1 = plus.remove();
            int data2 = plus.remove();
            sum += (data1 * data2);
        }

        if (!plus.isEmpty()) {
            sum += plus.remove();
        }

        if (!minus.isEmpty()) {
            sum += minus.remove();
        }

        System.out.println(sum + one);
        br.close();
    }
}
